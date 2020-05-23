package com.cross.uaa.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table(name = "jhi_user_authority")
public class UserAuthority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="authority_name")
    private String authorityName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAuthority that = (UserAuthority) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return authorityName != null ? authorityName.equals(that.authorityName) : that.authorityName == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (authorityName != null ? authorityName.hashCode() : 0);
        return result;
    }
}
