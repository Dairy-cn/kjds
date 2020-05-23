package com.cross.merchants.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * 企业信息
 */
@Entity
@Table(name = "enterprise_info")
public class EnterpriseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户id
     */
    @Column(name = "merchant_id",nullable = false)
    @NotNull
    private Long merchantId;

    /**
     * 银行开户名
     */
    @Column(name = "open_bank_name")
    private String openBankName;

    /**
     * 开户证明图片
     */
    @Column(name = "open_account_pic")
    private String openAccountPic;

    /**
     * 开户银行id
     */
    @Column(name = "bank_id")
    private Long bankId;

    /**
     * 对公银行账号
     */
    @Column(name = "for_corporate_bank_account_number")
    private String forCorporateBankAccountNumber;

    /**
     * 开户银行支行
     */
    @Column(name = "bank_branch")
    private String bankBranch;

    /**
     * 省id
     */
    @Column(name = "province_id")
    private Long provinceId;

    /**
     * 市Id
     */
    @Column(name = "city_id")
    private Long cityId;

    /**
     * 国家Id
     */
    @Column(name = "country_id")
    private Long countryId;

    /**
     * 省
     */
    @Column(name = "province")
    private String province;

    /**
     * 市
     */
    @Column(name = "city")
    private String city;

    /**
     * 国家
     */
    @Column(name = "country")
    private String country;

    /**
     * 开户所在详细地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 发票类型 1增值税普通发票  2增值税专用发票
     */
    @Column(name = "invoice_type")
    private Integer invoiceType;

    /**
     * 财务联系电话
     */
    @Column(name = "financial_contact_number")
    private String financialContactNumber;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public EnterpriseInfo merchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public String getOpenBankName() {
        return openBankName;
    }
    public EnterpriseInfo openBankName(String openBankName) {
        this.openBankName = openBankName;
        return this;
    }
    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getOpenAccountPic() {
        return openAccountPic;
    }

    public EnterpriseInfo openAccountPic(String openAccountPic) {
        this.openAccountPic = openAccountPic;
        return this;
    }

    public void setOpenAccountPic(String openAccountPic) {
        this.openAccountPic = openAccountPic;
    }

    public Long getBankId() {
        return bankId;
    }

    public EnterpriseInfo bankId(Long bankId) {
        this.bankId = bankId;
        return this;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getForCorporateBankAccountNumber() {
        return forCorporateBankAccountNumber;
    }

    public EnterpriseInfo forCorporateBankAccountNumber(String forCorporateBankAccountNumber) {
        this.forCorporateBankAccountNumber = forCorporateBankAccountNumber;
        return this;
    }

    public void setForCorporateBankAccountNumber(String forCorporateBankAccountNumber) {
        this.forCorporateBankAccountNumber = forCorporateBankAccountNumber;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public EnterpriseInfo bankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
        return this;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public EnterpriseInfo provinceId(Long provinceId) {
        this.provinceId = provinceId;
        return this;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public EnterpriseInfo cityId(Long cityId) {
        this.cityId = cityId;
        return this;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public EnterpriseInfo countryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getProvince() {
        return province;
    }

    public EnterpriseInfo province(String province) {
        this.province = province;
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public EnterpriseInfo city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public EnterpriseInfo country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public EnterpriseInfo address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public EnterpriseInfo invoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
        return this;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getFinancialContactNumber() {
        return financialContactNumber;
    }

    public EnterpriseInfo financialContactNumber(String financialContactNumber) {
        this.financialContactNumber = financialContactNumber;
        return this;
    }

    public void setFinancialContactNumber(String financialContactNumber) {
        this.financialContactNumber = financialContactNumber;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EnterpriseInfo)) {
            return false;
        }
        return id != null && id.equals(((EnterpriseInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "EnterpriseInfo{" +
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
