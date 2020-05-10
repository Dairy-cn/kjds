package com.cross.model;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the MerchantTable entity.
 */
public class MerchantTableDTO implements Serializable {

    private Long id;

    private Long merchantId;

    private String merchantNo;

    private String tableNo;

    private String tableName;

    private Integer state;

    private Integer sitNumber;

    private Boolean spellTable;

    private String introduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSitNumber() {
        return sitNumber;
    }

    public void setSitNumber(Integer sitNumber) {
        this.sitNumber = sitNumber;
    }

    public Boolean isSpellTable() {
        return spellTable;
    }

    public void setSpellTable(Boolean spellTable) {
        this.spellTable = spellTable;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MerchantTableDTO merchantTableDTO = (MerchantTableDTO) o;
        if(merchantTableDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), merchantTableDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MerchantTableDTO{" +
            "id=" + getId() +
            ", merchantId=" + getMerchantId() +
            ", merchantNo='" + getMerchantNo() + "'" +
            ", tableNo='" + getTableNo() + "'" +
            ", tableName='" + getTableName() + "'" +
            ", state=" + getState() +
            ", sitNumber=" + getSitNumber() +
            ", spellTable='" + isSpellTable() + "'" +
            ", introduction='" + getIntroduction() + "'" +
            "}";
    }
}
