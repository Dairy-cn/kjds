package com.cross.model;


import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ValidationCode entity.
 */
public class ValidationCodeModel implements Serializable {

    private Long id;

    @Size(max = 11)
    private String mobile;

    @Size(min = 6, max = 6)
    private String code;

    private Integer sendTime;

    private String sendIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSendTime() {
        return sendTime;
    }

    public void setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendIp() {
        return sendIp;
    }

    public void setSendIp(String sendIp) {
        this.sendIp = sendIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ValidationCodeModel validationCodeDTO = (ValidationCodeModel) o;
        if(validationCodeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), validationCodeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ValidationCodeDTO{" +
            "id=" + getId() +
            ", mobile='" + getMobile() + "'" +
            ", code='" + getCode() + "'" +
            ", sendTime='" + getSendTime() + "'" +
            ", sendIp='" + getSendIp() + "'" +
            "}";
    }
}
