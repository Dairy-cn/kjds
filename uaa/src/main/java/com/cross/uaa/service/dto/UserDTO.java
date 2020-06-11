package com.cross.uaa.service.dto;

import com.cross.uaa.config.Constants;

import com.cross.uaa.domain.Authority;
import com.cross.uaa.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a user, with his authorities.
 */
@ApiModel("用户信息相关")
public class UserDTO {

    private Long id;

    @NotBlank
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    @ApiModelProperty("登录账号")
    private String login;

    @Size(max = 50)
    @ApiModelProperty("姓")
    private String firstName;

    @Size(max = 50)
    @ApiModelProperty("名")
    private String lastName;

    @Email
    @Size(min = 5, max = 254)
    @ApiModelProperty("邮箱")
    private String email;

    @Size(max = 256)
    @ApiModelProperty("用户头像地址、图片地址")
    private String imageUrl;

    private boolean activated = true;

    @Size(min = 2, max = 10)
    private String langKey;

    @ApiModelProperty("创建人")
    private String createdBy;

    @ApiModelProperty("创建时间/注册时间")
    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;


    @ApiModelProperty("角色信息")
    private Set<String> authorities;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("身份证号码")
    private String idCard;

    @ApiModelProperty("身份证正面")
    private String idCardF;

    @ApiModelProperty("身份证反面")
    private String idCardR;


    @ApiModelProperty("用户ID,8位")
    private String userId;

    @ApiModelProperty("性别 1 男 2 女 0 未知")
    private Integer sex = 1;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("实名认证状态")
    private Boolean realNameAuthStatus;

    @ApiModelProperty("累计消费次数")
    private Long orderTotalTimes;

    @ApiModelProperty("累计消费金额")
    private BigDecimal orderTotalAmount;

    public UserDTO() {
        // Empty constructor needed for Jackson.
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.activated = user.getActivated();
        this.imageUrl = user.getImageUrl();
        this.langKey = user.getLangKey();
        this.createdBy = user.getCreatedBy();
        this.createdDate = user.getCreatedDate();
        this.lastModifiedBy = user.getLastModifiedBy();
        this.lastModifiedDate = user.getLastModifiedDate();
        this.authorities = user.getAuthorities().stream()
            .map(Authority::getName)
            .collect(Collectors.toSet());
        this.realName = user.getRealName();
        this.idCard = user.getIdCard();
        this.idCardF = user.getIdCardF();
        this.idCardR = user.getIdCardR();
        this.userId = user.getUserId();
        this.realNameAuthStatus = user.getRealNameAuthStatus();
        this.orderTotalTimes = user.getOrderTotalTimes();
        this.orderTotalAmount = user.getOrderTotalAmount();
        this.sex=user.getSex();
        this.mobile=user.getMobile();
        this.createdDate=user.getCreatedDate();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCardF() {
        return idCardF;
    }

    public void setIdCardF(String idCardF) {
        this.idCardF = idCardF;
    }

    public String getIdCardR() {
        return idCardR;
    }

    public void setIdCardR(String idCardR) {
        this.idCardR = idCardR;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getRealNameAuthStatus() {
        return realNameAuthStatus;
    }

    public void setRealNameAuthStatus(Boolean realNameAuthStatus) {
        this.realNameAuthStatus = realNameAuthStatus;
    }

    public Long getOrderTotalTimes() {
        return orderTotalTimes;
    }

    public void setOrderTotalTimes(Long orderTotalTimes) {
        this.orderTotalTimes = orderTotalTimes;
    }

    public BigDecimal getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "login='" + login + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", activated=" + activated +
            ", langKey='" + langKey + '\'' +
            ", createdBy=" + createdBy +
            ", createdDate=" + createdDate +
            ", lastModifiedBy='" + lastModifiedBy + '\'' +
            ", lastModifiedDate=" + lastModifiedDate +
            ", authorities=" + authorities +
            "}";
    }
}
