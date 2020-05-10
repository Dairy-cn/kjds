package com.cross.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


/**
 * Created by DuYuLiang on 2017/6/12.
 *
 */
public class UserDetailModel extends User {
    private Long userId;
    //private String openId;
    //private String alipayId;
    /*{"user_name":"18080166221","scope":["openid"],"id":25,"exp":1511191076,"authorities":["ROLE_ADMIN","ROLE_MERCHANT","ROLE_USER"],"jti":"937eae3b-24f6-4085-a753-32bea903b3c9",
    "client_id":"web_app"}
     */

    public UserDetailModel(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId) {
        super(username, password, true, true, true, true, authorities);
        this.userId = userId;
        //this.openId = openId;
        //this.alipayId = alipayId;
    }

    public UserDetailModel(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long userId) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
        //this.openId = openId;
        //this.alipayId = alipayId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

   /* public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }*/
}
