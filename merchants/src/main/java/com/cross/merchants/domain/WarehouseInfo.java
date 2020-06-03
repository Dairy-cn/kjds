package com.cross.merchants.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * 仓库信息
 */
@Entity
@Table(name = "warehouse_info")
public class WarehouseInfo implements Serializable {

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
     * 物流类型 1 商家发货
     */
    @Column(name = "shipping_region_type")
    private Integer shippingRegionType;

    /**
     * 仓库类型 1 自有仓库 2 三方代发
     */
    @Column(name = "warehouse_type")
    private Integer warehouseType;

    /**
     * 仓库面积
     */
    @Column(name = "warehouse_area")
    private Double warehouseArea;

    /**
     * 仓库操作人员数量
     */
    @Column(name = "warehouse_operators_number")
    private Integer warehouseOperatorsNumber;

    /**
     * 日发货单量 (单/日)
     */
    @Column(name = "daily_invoice_quantity")
    private Integer dailyInvoiceQuantity;

    /**
     * 签约快递
     */
    @Column(name = "signed_delivery")
    private String signedDelivery;

    /**
     * 发货软件名称
     */
    @Column(name = "shipping_software_name")
    private String shippingSoftwareName;

    /**
     * 联系人
     */
    @Column(name = "contacts")
    private String contacts;

    /**
     * 发货仓库手机
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * 仓库详细地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 退货仓库信息是否和发货仓库信息一致
     */
    @Column(name = "shipments_and_returns_info_no_difference")
    private Boolean shipmentsAndReturnsInfoNoDifference;

    /**
     * 是否支持自主售后
     */
    @Column(name = "open_independent_after_sales")
    private Boolean openIndependentAfterSales;

    /**
     * 退货仓库联系人
     */
    @Column(name = "return_warehouse_contact")
    private String returnWarehouseContact;

    /**
     * 退货仓库联系人
     */
    @Column(name = "return_warehouse_phone")
    private String returnWarehousePhone;

    /**
     * 发货仓库省id
     */
    @Column(name = "province_id")
    private Long provinceId;

    /**
     * 发货仓库市Id
     */
    @Column(name = "city_id")
    private Long cityId;

    /**
     * 发货仓库国家Id
     */
    @Column(name = "country_id")
    private Long countryID;

    /**
     * 发货仓库省
     */
    @Column(name = "province")
    private String province;

    /**
     * 发货仓库市
     */
    @Column(name = "city")
    private String city;

    /**
     * 发货仓库国家
     */
    @Column(name = "country")
    private String country;

    /**
     * 退货仓库省id(如果shipmentsAndReturnsInfoNoDifference为true 不传)
     */
    @Column(name = "return_warehouse_province_id")
    private Long returnWarehouseProvinceId;

    /**
     * 退货仓库市Id (如果shipmentsAndReturnsInfoNoDifference为true 不传)
     */
    @Column(name = "return_warehouse_city_id")
    private Long returnWarehouseCityId;

    /**
     * 退货仓库国家Id (如果shipmentsAndReturnsInfoNoDifference为true 不传)
     */
    @Column(name = "return_warehouse_country_id")
    private Long returnWarehouseCountryID;

    /**
     * 退货仓库省
     */
    @Column(name = "return_warehouse_province")
    private String returnWarehouseProvince;

    /**
     * 退货仓库市
     */
    @Column(name = "return_warehouse_city")
    private String returnWarehouseCity;

    /**
     * 退货仓库国家
     */
    @Column(name = "return_warehouse_country")
    private String returnWarehouseCountry;


    /**
     * 退货仓库详细地址
     */
    @ApiModelProperty(value = "退货仓库详细地址")
    @Column(name = "return_warehouse_address")
    private String returnWarehouseAddress;


    @ApiModelProperty(value = "发货区域类型 1 保税仓库区 2 境内非保税区  3 跨境直邮")
    @Column(name = "delivery_area_type")
    private Integer deliveryAreaType;


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public Integer getDeliveryAreaType() {
        return deliveryAreaType;
    }
    public WarehouseInfo deliveryAreaType(Integer deliveryAreaType) {
        this.deliveryAreaType = deliveryAreaType;
        return this;
    }
    public void setDeliveryAreaType(Integer deliveryAreaType) {
        this.deliveryAreaType = deliveryAreaType;
    }

    public Boolean getShipmentsAndReturnsInfoNoDifference() {
        return shipmentsAndReturnsInfoNoDifference;
    }

    public Boolean getOpenIndependentAfterSales() {
        return openIndependentAfterSales;
    }

    public String getReturnWarehouseAddress() {
        return returnWarehouseAddress;
    }
    public WarehouseInfo returnWarehouseAddress(String returnWarehouseAddress) {
        this.returnWarehouseAddress = returnWarehouseAddress;
        return this;
    }
    public void setReturnWarehouseAddress(String returnWarehouseAddress) {
        this.returnWarehouseAddress = returnWarehouseAddress;
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

    public WarehouseInfo merchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getShippingRegionType() {
        return shippingRegionType;
    }

    public WarehouseInfo shippingRegionType(Integer shippingRegionType) {
        this.shippingRegionType = shippingRegionType;
        return this;
    }

    public void setShippingRegionType(Integer shippingRegionType) {
        this.shippingRegionType = shippingRegionType;
    }

    public Integer getWarehouseType() {
        return warehouseType;
    }

    public WarehouseInfo warehouseType(Integer warehouseType) {
        this.warehouseType = warehouseType;
        return this;
    }

    public void setWarehouseType(Integer warehouseType) {
        this.warehouseType = warehouseType;
    }

    public Double getWarehouseArea() {
        return warehouseArea;
    }

    public WarehouseInfo warehouseArea(Double warehouseArea) {
        this.warehouseArea = warehouseArea;
        return this;
    }

    public void setWarehouseArea(Double warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public Integer getWarehouseOperatorsNumber() {
        return warehouseOperatorsNumber;
    }

    public WarehouseInfo warehouseOperatorsNumber(Integer warehouseOperatorsNumber) {
        this.warehouseOperatorsNumber = warehouseOperatorsNumber;
        return this;
    }

    public void setWarehouseOperatorsNumber(Integer warehouseOperatorsNumber) {
        this.warehouseOperatorsNumber = warehouseOperatorsNumber;
    }

    public Integer getDailyInvoiceQuantity() {
        return dailyInvoiceQuantity;
    }

    public WarehouseInfo dailyInvoiceQuantity(Integer dailyInvoiceQuantity) {
        this.dailyInvoiceQuantity = dailyInvoiceQuantity;
        return this;
    }

    public void setDailyInvoiceQuantity(Integer dailyInvoiceQuantity) {
        this.dailyInvoiceQuantity = dailyInvoiceQuantity;
    }

    public String getSignedDelivery() {
        return signedDelivery;
    }

    public WarehouseInfo signedDelivery(String signedDelivery) {
        this.signedDelivery = signedDelivery;
        return this;
    }

    public void setSignedDelivery(String signedDelivery) {
        this.signedDelivery = signedDelivery;
    }

    public String getShippingSoftwareName() {
        return shippingSoftwareName;
    }

    public WarehouseInfo shippingSoftwareName(String shippingSoftwareName) {
        this.shippingSoftwareName = shippingSoftwareName;
        return this;
    }

    public void setShippingSoftwareName(String shippingSoftwareName) {
        this.shippingSoftwareName = shippingSoftwareName;
    }

    public String getContacts() {
        return contacts;
    }

    public WarehouseInfo contacts(String contacts) {
        this.contacts = contacts;
        return this;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTelephone() {
        return telephone;
    }

    public WarehouseInfo telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public WarehouseInfo address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean isShipmentsAndReturnsInfoNoDifference() {
        return shipmentsAndReturnsInfoNoDifference;
    }

    public WarehouseInfo shipmentsAndReturnsInfoNoDifference(Boolean shipmentsAndReturnsInfoNoDifference) {
        this.shipmentsAndReturnsInfoNoDifference = shipmentsAndReturnsInfoNoDifference;
        return this;
    }

    public void setShipmentsAndReturnsInfoNoDifference(Boolean shipmentsAndReturnsInfoNoDifference) {
        this.shipmentsAndReturnsInfoNoDifference = shipmentsAndReturnsInfoNoDifference;
    }

    public Boolean isOpenIndependentAfterSales() {
        return openIndependentAfterSales;
    }

    public WarehouseInfo openIndependentAfterSales(Boolean openIndependentAfterSales) {
        this.openIndependentAfterSales = openIndependentAfterSales;
        return this;
    }

    public void setOpenIndependentAfterSales(Boolean openIndependentAfterSales) {
        this.openIndependentAfterSales = openIndependentAfterSales;
    }

    public String getReturnWarehouseContact() {
        return returnWarehouseContact;
    }

    public WarehouseInfo returnWarehouseContact(String returnWarehouseContact) {
        this.returnWarehouseContact = returnWarehouseContact;
        return this;
    }

    public void setReturnWarehouseContact(String returnWarehouseContact) {
        this.returnWarehouseContact = returnWarehouseContact;
    }

    public String getReturnWarehousePhone() {
        return returnWarehousePhone;
    }

    public WarehouseInfo returnWarehousePhone(String returnWarehousePhone) {
        this.returnWarehousePhone = returnWarehousePhone;
        return this;
    }

    public void setReturnWarehousePhone(String returnWarehousePhone) {
        this.returnWarehousePhone = returnWarehousePhone;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public WarehouseInfo provinceId(Long provinceId) {
        this.provinceId = provinceId;
        return this;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public WarehouseInfo cityId(Long cityId) {
        this.cityId = cityId;
        return this;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountryID() {
        return countryID;
    }

    public WarehouseInfo countryID(Long countryID) {
        this.countryID = countryID;
        return this;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    public String getProvince() {
        return province;
    }

    public WarehouseInfo province(String province) {
        this.province = province;
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public WarehouseInfo city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public WarehouseInfo country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getReturnWarehouseProvinceId() {
        return returnWarehouseProvinceId;
    }

    public WarehouseInfo returnWarehouseProvinceId(Long returnWarehouseProvinceId) {
        this.returnWarehouseProvinceId = returnWarehouseProvinceId;
        return this;
    }

    public void setReturnWarehouseProvinceId(Long returnWarehouseProvinceId) {
        this.returnWarehouseProvinceId = returnWarehouseProvinceId;
    }

    public Long getReturnWarehouseCityId() {
        return returnWarehouseCityId;
    }

    public WarehouseInfo returnWarehouseCityId(Long returnWarehouseCityId) {
        this.returnWarehouseCityId = returnWarehouseCityId;
        return this;
    }

    public void setReturnWarehouseCityId(Long returnWarehouseCityId) {
        this.returnWarehouseCityId = returnWarehouseCityId;
    }

    public Long getReturnWarehouseCountryID() {
        return returnWarehouseCountryID;
    }

    public WarehouseInfo returnWarehouseCountryID(Long returnWarehouseCountryID) {
        this.returnWarehouseCountryID = returnWarehouseCountryID;
        return this;
    }

    public void setReturnWarehouseCountryID(Long returnWarehouseCountryID) {
        this.returnWarehouseCountryID = returnWarehouseCountryID;
    }

    public String getReturnWarehouseProvince() {
        return returnWarehouseProvince;
    }

    public WarehouseInfo returnWarehouseProvince(String returnWarehouseProvince) {
        this.returnWarehouseProvince = returnWarehouseProvince;
        return this;
    }

    public void setReturnWarehouseProvince(String returnWarehouseProvince) {
        this.returnWarehouseProvince = returnWarehouseProvince;
    }

    public String getReturnWarehouseCity() {
        return returnWarehouseCity;
    }

    public WarehouseInfo returnWarehouseCity(String returnWarehouseCity) {
        this.returnWarehouseCity = returnWarehouseCity;
        return this;
    }

    public void setReturnWarehouseCity(String returnWarehouseCity) {
        this.returnWarehouseCity = returnWarehouseCity;
    }

    public String getReturnWarehouseCountry() {
        return returnWarehouseCountry;
    }

    public WarehouseInfo returnWarehouseCountry(String returnWarehouseCountry) {
        this.returnWarehouseCountry = returnWarehouseCountry;
        return this;
    }

    public void setReturnWarehouseCountry(String returnWarehouseCountry) {
        this.returnWarehouseCountry = returnWarehouseCountry;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WarehouseInfo)) {
            return false;
        }
        return id != null && id.equals(((WarehouseInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "WarehouseInfo{" +
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
