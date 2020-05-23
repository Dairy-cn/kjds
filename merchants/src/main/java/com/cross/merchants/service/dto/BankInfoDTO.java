package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.BankInfo} entity.
 */
@ApiModel(description = "银行信息")
public class BankInfoDTO implements Serializable {
    
    private Long id;

    /**
     * 银行名称
     */
    @ApiModelProperty(value = "银行名称")
    private String name;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BankInfoDTO bankInfoDTO = (BankInfoDTO) o;
        if (bankInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bankInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BankInfoDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
