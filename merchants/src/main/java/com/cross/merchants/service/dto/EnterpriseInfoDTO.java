package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.EnterpriseInfo} entity.
 */
@ApiModel(description = "企业信息")
public class EnterpriseInfoDTO implements Serializable {

    private Long id;

    /**
     * 商户id
     */
    @ApiModelProperty(value = "商户id",required = true)
    @NotNull
    private Long merchantId;


    /**
     * 银行开户名
     */
    @ApiModelProperty(value = "银行开户名")
    private String openBankName;

    /**
     * 开户证明图片
     */
    @ApiModelProperty(value = "开户证明图片")
    private List<String> openAccountPic;

    /**
     * 开户银行id
     */
    @ApiModelProperty(value = "开户银行id")
    private Long bankId;

    /**
     * 开户银行
     */
    @ApiModelProperty(value = "开户银行",hidden = true)
    private String bankName;

    /**
     * 对公银行账号
     */
    @ApiModelProperty(value = "对公银行账号")
    private String forCorporateBankAccountNumber;

    /**
     * 开户银行支行
     */
    @ApiModelProperty(value = "开户银行支行")
    private String bankBranch;

    /**
     * 省id
     */
    @ApiModelProperty(value = "省id")
    private Long provinceId;

    /**
     * 市Id
     */
    @ApiModelProperty(value = "市Id")
    private Long cityId;

    /**
     * 国家Id
     */
    @ApiModelProperty(value = "国家Id")
    private Long countryId;

    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;

    /**
     * 国家
     */
    @ApiModelProperty(value = "国家")
    private String country;

    /**
     * 开户所在详细地址
     */
    @ApiModelProperty(value = "开户所在详细地址")
    private String address;

    /**
     * 发票类型 1增值税普通发票  2增值税专用发票
     */
    @ApiModelProperty(value = "发票类型 1增值税普通发票  2增值税专用发票")
    private Integer invoiceType;

    /**
     * 财务联系电话
     */
    @ApiModelProperty(value = "财务联系电话")
    private String financialContactNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

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


    public String getOpenBankName() {
        return openBankName;
    }

    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    public List<String> getOpenAccountPic() {
        return openAccountPic;
    }

    public void setOpenAccountPic(List<String> openAccountPic) {
        this.openAccountPic = openAccountPic;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getForCorporateBankAccountNumber() {
        return forCorporateBankAccountNumber;
    }

    public void setForCorporateBankAccountNumber(String forCorporateBankAccountNumber) {
        this.forCorporateBankAccountNumber = forCorporateBankAccountNumber;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getFinancialContactNumber() {
        return financialContactNumber;
    }

    public void setFinancialContactNumber(String financialContactNumber) {
        this.financialContactNumber = financialContactNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EnterpriseInfoDTO enterpriseInfoDTO = (EnterpriseInfoDTO) o;
        if (enterpriseInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), enterpriseInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EnterpriseInfoDTO{" +
            "id=" + getId() +
            ", merchantId=" + getMerchantId() +
            ", openAccountPic='" + getOpenAccountPic() + "'" +
            ", bankId=" + getBankId() +
            ", forCorporateBankAccountNumber='" + getForCorporateBankAccountNumber() + "'" +
            ", bankBranch='" + getBankBranch() + "'" +
            ", provinceId=" + getProvinceId() +
            ", cityId=" + getCityId() +
            ", countryId=" + getCountryId() +
            ", province='" + getProvince() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            ", address='" + getAddress() + "'" +
            ", invoiceType=" + getInvoiceType() +
            ", financialContactNumber='" + getFinancialContactNumber() + "'" +
            "}";
    }
}
