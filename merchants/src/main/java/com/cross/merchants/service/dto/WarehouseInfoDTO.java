package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.WarehouseInfo} entity.
 */
@ApiModel(description = "仓库信息")
public class WarehouseInfoDTO implements Serializable {

    private Long id;

    /**
     * 商户id
     */
    @ApiModelProperty(value = "商户id",required = true)
    @NotNull
    private Long merchantId;

    /**
     * 物流类型 1 商家发货
     */
    @ApiModelProperty(value = "物流类型 1 商家发货")
    private Integer shippingRegionType;

    /**
     * 仓库类型 1 自有仓库 2 三方代发
     */
    @ApiModelProperty(value = "仓库类型 1 自有仓库 2 三方代发")
    private Integer warehouseType;

    /**
     * 仓库面积
     */
    @ApiModelProperty(value = "仓库面积")
    private Double warehouseArea;

    /**
     * 仓库操作人员数量
     */
    @ApiModelProperty(value = "仓库操作人员数量")
    private Integer warehouseOperatorsNumber;

    /**
     * 日发货单量 (单/日)
     */
    @ApiModelProperty(value = "日发货单量 (单/日)")
    private Integer dailyInvoiceQuantity;

    /**
     * 签约快递
     */
    @ApiModelProperty(value = "签约快递")
    private String signedDelivery;

    /**
     * 发货软件名称
     */
    @ApiModelProperty(value = "发货软件名称")
    private String shippingSoftwareName;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String contacts;

    /**
     * 发货仓库手机
     */
    @ApiModelProperty(value = "发货仓库手机")
    private String telephone;

    /**
     * 仓库详细地址
     */
    @ApiModelProperty(value = "仓库详细地址")
    private String address;

    /**
     * 退货仓库信息是否和发货仓库信息一致
     */
    @ApiModelProperty(value = "退货仓库信息是否和发货仓库信息一致")
    private Boolean shipmentsAndReturnsInfoNoDifference;

    /**
     * 是否支持自主售后
     */
    @ApiModelProperty(value = "是否支持自主售后")
    private Boolean openIndependentAfterSales;

    /**
     * 退货仓库联系人
     */
    @ApiModelProperty(value = "退货仓库联系人")
    private String returnWarehouseContact;

    /**
     * 退货仓库联系人
     */
    @ApiModelProperty(value = "退货仓库联系人")
    private String returnWarehousePhone;

    /**
     * 发货仓库省id
     */
    @ApiModelProperty(value = "发货仓库省id")
    private Long provinceId;

    /**
     * 发货仓库市Id
     */
    @ApiModelProperty(value = "发货仓库市Id")
    private Long cityId;

    /**
     * 发货仓库国家Id
     */
    @ApiModelProperty(value = "发货仓库国家Id")
    private Long countryID;

    /**
     * 发货仓库省
     */
    @ApiModelProperty(value = "发货仓库省")
    private String province;

    /**
     * 发货仓库市
     */
    @ApiModelProperty(value = "发货仓库市")
    private String city;

    /**
     * 发货仓库国家
     */
    @ApiModelProperty(value = "发货仓库国家")
    private String country;

    /**
     * 退货仓库省id(如果shipmentsAndReturnsInfoNoDifference为true 不传)
     */
    @ApiModelProperty(value = "退货仓库省id(如果shipmentsAndReturnsInfoNoDifference为true 不传)")
    private Long returnWarehouseProvinceId;

    /**
     * 退货仓库市Id (如果shipmentsAndReturnsInfoNoDifference为true 不传)
     */
    @ApiModelProperty(value = "退货仓库市Id (如果shipmentsAndReturnsInfoNoDifference为true 不传)")
    private Long returnWarehouseCityId;

    /**
     * 退货仓库国家Id (如果shipmentsAndReturnsInfoNoDifference为true 不传)
     */
    @ApiModelProperty(value = "退货仓库国家Id (如果shipmentsAndReturnsInfoNoDifference为true 不传)")
    private Long returnWarehouseCountryID;

    /**
     * 退货仓库省
     */
    @ApiModelProperty(value = "退货仓库省")
    private String returnWarehouseProvince;

    /**
     * 退货仓库市
     */
    @ApiModelProperty(value = "退货仓库市")
    private String returnWarehouseCity;

    /**
     * 退货仓库国家
     */
    @ApiModelProperty(value = "退货仓库国家")
    private String returnWarehouseCountry;

    /**
     * 退货仓库详细地址
     */
    @ApiModelProperty(value = "退货仓库详细地址 (如果shipmentsAndReturnsInfoNoDifference为true 不传)")
    private String returnWarehouseAddress;

    public String getReturnWarehouseAddress() {
        return returnWarehouseAddress;
    }

    public void setReturnWarehouseAddress(String returnWarehouseAddress) {
        this.returnWarehouseAddress = returnWarehouseAddress;
    }

    public Boolean getShipmentsAndReturnsInfoNoDifference() {
        return shipmentsAndReturnsInfoNoDifference;
    }

    public Boolean getOpenIndependentAfterSales() {
        return openIndependentAfterSales;
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

    public Integer getShippingRegionType() {
        return shippingRegionType;
    }

    public void setShippingRegionType(Integer shippingRegionType) {
        this.shippingRegionType = shippingRegionType;
    }

    public Integer getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(Integer warehouseType) {
        this.warehouseType = warehouseType;
    }

    public Double getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(Double warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public Integer getWarehouseOperatorsNumber() {
        return warehouseOperatorsNumber;
    }

    public void setWarehouseOperatorsNumber(Integer warehouseOperatorsNumber) {
        this.warehouseOperatorsNumber = warehouseOperatorsNumber;
    }

    public Integer getDailyInvoiceQuantity() {
        return dailyInvoiceQuantity;
    }

    public void setDailyInvoiceQuantity(Integer dailyInvoiceQuantity) {
        this.dailyInvoiceQuantity = dailyInvoiceQuantity;
    }

    public String getSignedDelivery() {
        return signedDelivery;
    }

    public void setSignedDelivery(String signedDelivery) {
        this.signedDelivery = signedDelivery;
    }

    public String getShippingSoftwareName() {
        return shippingSoftwareName;
    }

    public void setShippingSoftwareName(String shippingSoftwareName) {
        this.shippingSoftwareName = shippingSoftwareName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean isShipmentsAndReturnsInfoNoDifference() {
        return shipmentsAndReturnsInfoNoDifference;
    }

    public void setShipmentsAndReturnsInfoNoDifference(Boolean shipmentsAndReturnsInfoNoDifference) {
        this.shipmentsAndReturnsInfoNoDifference = shipmentsAndReturnsInfoNoDifference;
    }

    public Boolean isOpenIndependentAfterSales() {
        return openIndependentAfterSales;
    }

    public void setOpenIndependentAfterSales(Boolean openIndependentAfterSales) {
        this.openIndependentAfterSales = openIndependentAfterSales;
    }

    public String getReturnWarehouseContact() {
        return returnWarehouseContact;
    }

    public void setReturnWarehouseContact(String returnWarehouseContact) {
        this.returnWarehouseContact = returnWarehouseContact;
    }

    public String getReturnWarehousePhone() {
        return returnWarehousePhone;
    }

    public void setReturnWarehousePhone(String returnWarehousePhone) {
        this.returnWarehousePhone = returnWarehousePhone;
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

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
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

    public Long getReturnWarehouseProvinceId() {
        return returnWarehouseProvinceId;
    }

    public void setReturnWarehouseProvinceId(Long returnWarehouseProvinceId) {
        this.returnWarehouseProvinceId = returnWarehouseProvinceId;
    }

    public Long getReturnWarehouseCityId() {
        return returnWarehouseCityId;
    }

    public void setReturnWarehouseCityId(Long returnWarehouseCityId) {
        this.returnWarehouseCityId = returnWarehouseCityId;
    }

    public Long getReturnWarehouseCountryID() {
        return returnWarehouseCountryID;
    }

    public void setReturnWarehouseCountryID(Long returnWarehouseCountryID) {
        this.returnWarehouseCountryID = returnWarehouseCountryID;
    }

    public String getReturnWarehouseProvince() {
        return returnWarehouseProvince;
    }

    public void setReturnWarehouseProvince(String returnWarehouseProvince) {
        this.returnWarehouseProvince = returnWarehouseProvince;
    }

    public String getReturnWarehouseCity() {
        return returnWarehouseCity;
    }

    public void setReturnWarehouseCity(String returnWarehouseCity) {
        this.returnWarehouseCity = returnWarehouseCity;
    }

    public String getReturnWarehouseCountry() {
        return returnWarehouseCountry;
    }

    public void setReturnWarehouseCountry(String returnWarehouseCountry) {
        this.returnWarehouseCountry = returnWarehouseCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WarehouseInfoDTO warehouseInfoDTO = (WarehouseInfoDTO) o;
        if (warehouseInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), warehouseInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WarehouseInfoDTO{" +
            "id=" + getId() +
            ", merchantId=" + getMerchantId() +
            ", shippingRegionType=" + getShippingRegionType() +
            ", warehouseType=" + getWarehouseType() +
            ", warehouseArea=" + getWarehouseArea() +
            ", warehouseOperatorsNumber=" + getWarehouseOperatorsNumber() +
            ", dailyInvoiceQuantity=" + getDailyInvoiceQuantity() +
            ", signedDelivery='" + getSignedDelivery() + "'" +
            ", shippingSoftwareName='" + getShippingSoftwareName() + "'" +
            ", contacts='" + getContacts() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", address='" + getAddress() + "'" +
            ", shipmentsAndReturnsInfoNoDifference='" + isShipmentsAndReturnsInfoNoDifference() + "'" +
            ", openIndependentAfterSales='" + isOpenIndependentAfterSales() + "'" +
            ", returnWarehouseContact='" + getReturnWarehouseContact() + "'" +
            ", returnWarehousePhone='" + getReturnWarehousePhone() + "'" +
            ", provinceId=" + getProvinceId() +
            ", cityId=" + getCityId() +
            ", countryID=" + getCountryID() +
            ", province='" + getProvince() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            ", returnWarehouseProvinceId=" + getReturnWarehouseProvinceId() +
            ", returnWarehouseCityId=" + getReturnWarehouseCityId() +
            ", returnWarehouseCountryID=" + getReturnWarehouseCountryID() +
            ", returnWarehouseProvince='" + getReturnWarehouseProvince() + "'" +
            ", returnWarehouseCity='" + getReturnWarehouseCity() + "'" +
            ", returnWarehouseCountry='" + getReturnWarehouseCountry() + "'" +
            "}";
    }
}
