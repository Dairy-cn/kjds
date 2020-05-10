package com.cross.model;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;

/**
 * <类的描述>
 * Created by LY on 2017/12/12.
 */
public class ManagedUserVM extends UserModel {

    public static final int PASSWORD_MIN_LENGTH = 4;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    private String identity;
    
    private String login;
    
    private Long id;
    
    @Override
    public Long getId() {
        return id;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String getLogin() {
        return login;
    }
    
    @Override
    public void setLogin(String login) {
        this.login = login;
    }
    
    public ManagedUserVM() {
        // Empty constructor needed for Jackson.
    }

    public ManagedUserVM(Long id, String login, String password, String firstName, String lastName,
                  String email, boolean activated, String imageUrl, String langKey,
                  String createdBy, Instant createdDate, String lastModifiedBy, Instant lastModifiedDate,
                  Set<String> authorities,String appId,Integer sex) {

        super(id, login, firstName, lastName, email, activated, imageUrl, langKey,
            createdBy, createdDate, lastModifiedBy, lastModifiedDate,  authorities,appId,sex);

        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
