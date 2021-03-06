package com.cross.uaa.web.rest;

import com.cross.DTO.UserOrderCountAndAmountDTO;
import com.cross.client.MerchantsService;
import com.cross.interfaces.phone.Phone;
import com.cross.uaa.config.Constants;
import com.cross.uaa.domain.Authority;
import com.cross.uaa.domain.User;
import com.cross.uaa.repository.UserRepository;
import com.cross.uaa.security.AuthoritiesConstants;
import com.cross.uaa.security.DomainUserDetailsService;
import com.cross.uaa.security.QxhUserDetail;
import com.cross.uaa.service.MailService;
import com.cross.uaa.service.UserService;
import com.cross.uaa.service.dto.UserDTO;
import com.cross.uaa.utils.AliYunUtil;
import com.cross.uaa.web.rest.errors.BadRequestAlertException;
import com.cross.uaa.web.rest.errors.EmailAlreadyUsedException;
import com.cross.uaa.web.rest.errors.LoginAlreadyUsedException;

import com.cross.utils.CommonUtil;
import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liquibase.pro.packaged.A;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * REST controller for managing users.
 * <p>
 * This class accesses the {@link User} entity, and needs to fetch its collection of authorities.
 * <p>
 * For a normal use-case, it would be better to have an eager relationship between User and Authority,
 * and send everything to the client side: there would be no View Model and DTO, a lot less code, and an outer-join
 * which would be good for performance.
 * <p>
 * We use a View Model and a DTO for 3 reasons:
 * <ul>
 * <li>We want to keep a lazy association between the user and the authorities, because people will
 * quite often do relationships with the user, and we don't want them to get the authorities all
 * the time for nothing (for performance reasons). This is the #1 goal: we should not impact our users'
 * application because of this use-case.</li>
 * <li> Not having an outer join causes n+1 requests to the database. This is not a real issue as
 * we have by default a second-level cache. This means on the first HTTP call we do the n+1 requests,
 * but then all authorities come from the cache, so in fact it's much better than doing an outer join
 * (which will get lots of data from the database, for each HTTP call).</li>
 * <li> As this manages users, for security reasons, we'd rather have a DTO layer.</li>
 * </ul>
 * <p>
 * Another option would be to have a specific JPA entity graph to handle this case.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "??????????????????")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserService userService;

    private final UserRepository userRepository;

    private final MailService mailService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DomainUserDetailsService domainUserDetailsService;

    @Autowired
    private AliYunUtil aliYunUtil;

    @Autowired
    private MerchantsService merchantsService;


    private final Integer cacheTime = 15;

    public UserResource(UserService userService, UserRepository userRepository, MailService mailService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    /**
     * {@code POST  /users}  : Creates a new user.
     * <p>
     * Creates a new user if the login and email are not already used, and sends an
     * mail with an activation link.
     * The user needs to be activated on creation.
     *
     * @param userDTO the user to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new user, or with status {@code 400 (Bad Request)} if the login or email is already in use.
     * @throws URISyntaxException       if the Location URI syntax is incorrect.
     * @throws BadRequestAlertException {@code 400 (Bad Request)} if the login or email is already in use.
     */
    @PostMapping("/users")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", userDTO);

        if (userDTO.getId() != null) {
            throw new BadRequestAlertException("A new user cannot already have an ID", "userManagement", "idexists");
            // Lowercase the user login before comparing with database
        } else if (userRepository.findOneByLogin(userDTO.getLogin().toLowerCase()).isPresent()) {
            throw new LoginAlreadyUsedException();
        } else if (userRepository.findOneByEmailIgnoreCase(userDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyUsedException();
        } else {
            User newUser = userService.createUser(userDTO);
            mailService.sendCreationEmail(newUser);
            return ResponseEntity.created(new URI("/api/users/" + newUser.getLogin()))
                .headers(HeaderUtil.createAlert(applicationName, "userManagement.created", newUser.getLogin()))
                .body(newUser);
        }
    }

    /**
     * {@code PUT /users} : Updates an existing User.
     *
     * @param userDTO the user to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated user.
     * @throws EmailAlreadyUsedException {@code 400 (Bad Request)} if the email is already in use.
     * @throws LoginAlreadyUsedException {@code 400 (Bad Request)} if the login is already in use.
     */
    @PutMapping("/users")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO) {
        log.debug("REST request to update User : {}", userDTO);
        Optional<User> existingUser = userRepository.findOneByEmailIgnoreCase(userDTO.getEmail());
        if (existingUser.isPresent() && (!existingUser.get().getId().equals(userDTO.getId()))) {
            throw new EmailAlreadyUsedException();
        }
        existingUser = userRepository.findOneByLogin(userDTO.getLogin().toLowerCase());
        if (existingUser.isPresent() && (!existingUser.get().getId().equals(userDTO.getId()))) {
            throw new LoginAlreadyUsedException();
        }
        Optional<UserDTO> updatedUser = userService.updateUser(userDTO);

        return ResponseUtil.wrapOrNotFound(updatedUser,
            HeaderUtil.createAlert(applicationName, "userManagement.updated", userDTO.getLogin()));
    }

    /**
     * {@code GET /users} : get all users.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body all users.
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(Pageable pageable) {
        final Page<UserDTO> page = userService.getAllManagedUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * Gets a list of all roles.
     *
     * @return a string list of all roles.
     */
    @GetMapping("/users/authorities")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public List<String> getAuthorities() {
        return userService.getAuthorities();
    }

    /**
     * {@code GET /users/:login} : get the "login" user.
     *
     * @param login the login of the user to find.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the "login" user, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/users/{login:" + Constants.LOGIN_REGEX + "}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String login) {
        log.debug("REST request to get User : {}", login);
        return ResponseUtil.wrapOrNotFound(
            userService.getUserWithAuthoritiesByLogin(login)
                .map(UserDTO::new));
    }


    @GetMapping("/query-users/{id}")
    @ApiOperation("????????????id??????????????????")
    public R getUser(@PathVariable Long id) {
        log.debug("REST request to get User : {}", id);
        return R.ok(userService.getOne(id));
    }

    /**
     * {@code DELETE /users/:login} : delete the "login" User.
     *
     * @param login the login of the user to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/users/{login:" + Constants.LOGIN_REGEX + "}")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<Void> deleteUser(@PathVariable String login) {
        log.debug("REST request to delete User: {}", login);
        userService.deleteUser(login);
        return ResponseEntity.noContent().headers(HeaderUtil.createAlert(applicationName, "userManagement.deleted", login)).build();
    }


    /**
     * ??????????????????????????????
     *
     * @param username
     * @param code
     * @return
     */
    @GetMapping("/merchant/mobile-quick-login/{username:" + Constants.LOGIN_REGEX + "}")
    @ApiOperation("??????????????????????????????")
    public R mobileQuickLoginByMerchant(@ApiParam(required = true, value = "????????????") @PathVariable String username,
                                        @ApiParam(required = true, value = "??????") @RequestParam String password,
                                        @ApiParam(required = true, value = "???????????????") @RequestParam String code) {
        Long partnerCode = null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String mobileCode = operations.get(username);
        if (code == null) {
            return R.error("??????????????????");
        } else if (mobileCode == null) {
            return R.error("??????????????????");
        } else if (!code.equalsIgnoreCase(mobileCode)) {
            return R.error("??????????????????");
        } else {
            QxhUserDetail user = null;
            try {
                user = domainUserDetailsService.loadUserByUsername(username);
            } catch (Exception e) {

            }
            if (user == null) {
                // ?????????????????? ???????????????????????????
                Authority authority = new Authority();
                authority.setName(AuthoritiesConstants.ADMIN);
                Set<Authority> authorities = new HashSet<>();
                authorities.add(authority);
                // ????????????
                userService.createUser(username, password, username, username, username + "@kjds.com", "", "zh-cn", authorities, true, 0, partnerCode);
            } else {
                User dbUser = userService.getUserWithAuthoritiesByLogin(username).get();
                Set<Authority> authorities = dbUser.getAuthorities();
                Authority authority = new Authority();
                authority.setName(AuthoritiesConstants.ADMIN);
                if (authorities.contains(authority)) {
                    return R.error("???????????????????????????");
                } else {
                    authorities.add(authority);
                }
                userService.update(dbUser);
            }
            operations.set(username, null, 1, TimeUnit.SECONDS);
            return R.ok();
        }
    }


    /**
     * ??????????????????????????????
     *
     * @param username
     * @param details
     * @return
     */
    @GetMapping("/user/mobile-quick-login/{username:" + Constants.LOGIN_REGEX + "}")
    @ApiOperation("??????????????????????????????")
    public R mobileQuickLoginByUser(@ApiParam(required = true, value = "????????????") @PathVariable String username,
                                    @ApiParam(required = true, value = "??????") @RequestParam String password,
                                    @ApiParam(required = true, value = "???????????????") @RequestParam String code) {
        Long partnerCode = null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String mobileCode = operations.get(username);
        if (code == null) {
            return R.error("??????????????????");
        } else if (mobileCode == null) {
            return R.error("??????????????????");
        } else if (!code.equalsIgnoreCase(mobileCode)) {
            return R.error("??????????????????");
        } else {
            QxhUserDetail user = null;
            try {
                user = domainUserDetailsService.loadUserByUsername(username);
            } catch (Exception e) {

            }
            if (user == null) {
                // ?????????????????? ???????????????????????????
                Authority authority = new Authority();
                authority.setName(AuthoritiesConstants.USER);
                Set<Authority> authorities = new HashSet<>();
                authorities.add(authority);

                // ????????????
                userService.createUser(username, password, username, username, username + "@kjds.com", "", "zh-cn", authorities, true, 0, partnerCode);

            } else {
                User dbUser = userService.getUserWithAuthoritiesByLogin(username).get();
                Set<Authority> authorities = dbUser.getAuthorities();
                Authority authority = new Authority();
                authority.setName(AuthoritiesConstants.USER);
                if (authorities.contains(authority)) {
                    return R.error("???????????????????????????");
                } else {
                    authorities.add(authority);
                }
                userService.update(dbUser);
            }
            operations.set(username, null, 1, TimeUnit.SECONDS);
            return R.ok();
        }
    }

    @GetMapping("/send-validation-code/{mobile}")
    @ApiOperation("???????????????")
    public R sendValidationCodeBySms(@PathVariable String mobile) {
        log.info("send validation code : {}", mobile);
        boolean matches = Pattern.matches(Constants.PHONE_REGEX, mobile);
        if (!matches) {
            return R.error("?????????????????????");
        }
        String code = aliYunUtil.init().sendValidationCodeSMS(mobile);

        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        // ??????????????????
        operations.set(mobile, code, cacheTime, TimeUnit.MINUTES);

        return R.ok(code);
    }

    @PutMapping("/real-name-auth")
    @ApiOperation("???????????????")
    public R realNameAuth(@ApiParam(value = "????????????", required = true) @RequestParam(required = true) String realname,
                          @ApiParam(value = "???????????????", required = true) @RequestParam(required = true) String idCard,
                          @ApiParam(value = "?????????????????????", required = true) @RequestParam(required = true) String phone,
                          @ApiParam(value = "???????????????", required = false) @RequestParam(required = false) String idCardF,
                          @ApiParam(value = "???????????????", required = false) @RequestParam(required = false) String idCardR) {


        Long id = CommonUtil.getCurrentLoginUser().getId();
        UserDTO one = userService.getOne(id);
        if (one == null) {
            return R.error();
        }
        one.setRealName(realname);
        one.setIdCard(idCard);
        one.setMobile(phone);
        one.setIdCardF(idCardF);
        one.setIdCardR(idCardR);
        one = userService.save(one);
        return R.ok(one);
    }


    @PutMapping("/reset/pwd/{phone}")
    @ApiOperation("????????????")
    public R resetPwd(@PathVariable String phone, @RequestParam String pwd, @RequestParam String code) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String mobileCode = operations.get(phone);
        if (code == null) {
            return R.error("??????????????????");
        } else if (mobileCode == null) {
            return R.error("??????????????????");
        } else if (!code.equalsIgnoreCase(mobileCode)) {
            return R.error("??????????????????");
        } else {
            QxhUserDetail user = null;
            try {
                user = domainUserDetailsService.loadUserByUsername(phone);
            } catch (Exception e) {

            }
            userService.resetPassword(phone, pwd);
            operations.set(phone, null, 1, TimeUnit.SECONDS);
        }
        return R.ok();
    }


    @GetMapping("/users-page-list")
    @ApiOperation("?????????--??????????????????")
    public R getAllUsers(Pageable pageable,
                         @ApiParam("??????????????????") @RequestParam(required = false) Instant registerStartTime,
                         @ApiParam("??????????????????") @RequestParam(required = false) Instant registerEndTime,
                         @ApiParam("??????Id/????????????") @RequestParam(required = false) String keyWord
    ) {
        Page<UserDTO> page = userService.getAllUsersByCondition(pageable, registerStartTime, registerEndTime, keyWord);
        List<UserDTO> content = page.getContent();
        if (!CollectionUtils.isEmpty(content)) {
            List<Long> ids = content.stream().map(UserDTO::getId).collect(Collectors.toList());
            R<Map<Long, UserOrderCountAndAmountDTO>> result = merchantsService.getOrderCountAndAmountByUserIds(ids);
            Map<Long, UserOrderCountAndAmountDTO> resultData = result.getData();
            if (resultData != null) {
                content.stream().forEach(e -> {
                    UserOrderCountAndAmountDTO userOrderCountAndAmountDTO = resultData.get(e.getId());
                    if (userOrderCountAndAmountDTO != null) {
                        e.setOrderTotalTimes(userOrderCountAndAmountDTO.getTotalOrderCount());
                        e.setOrderTotalAmount(userOrderCountAndAmountDTO.getTotalPayAmount());
                    }
                });
            }

        }

        return R.ok(content, page.getTotalElements());
    }

}
