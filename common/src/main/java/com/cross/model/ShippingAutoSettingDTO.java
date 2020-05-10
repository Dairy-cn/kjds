package com.cross.model;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ShippingAutoSetting entity.
 */
public class ShippingAutoSettingDTO implements Serializable {

    private Long id;

    private Long merchantId;

    private Long brandId;

    private Boolean autoShipping;

    private Boolean autoEnable;

    private String DaDaType;

    private Integer ddStatus;

    private String ddTel;

    private String dadaDetailedAddress;

    private String dwdStatus;

    private String dwdTel;

    private String dwdDetailedAddress;

    //private List<> list =  new ArrayList<>();

    public Integer getDdStatus(){
        return ddStatus;
    }

    public void setDdStatus(Integer ddStatus){
        this.ddStatus = ddStatus;
    }

    public String getDadaDetailedAddress(){
        return dwdDetailedAddress;
    }

    public void setDwdDetailedAddress(String dwdDetailedAddress){
        this.dwdDetailedAddress = dwdDetailedAddress;
    }

    public String getDwdTel(){
        return dwdTel;
    }

    public void setDwdTel(String dwdTel1){
        this.dwdTel = dwdTel1;
    }

    public String getDwdStatus(){
        return dwdStatus;
    }

    public void setDwdStatus(String dwdStatus){
        this.dwdStatus = dwdStatus;
    }

    public String getDetailedAddress(){
        return dadaDetailedAddress;
    }

    public void setDetailedAddress(String dadaDetailedAddress){
        this.dadaDetailedAddress=dadaDetailedAddress;
    }

    public String getTel(){
        return ddTel;
    }

    public void setTel(String ddTel){
        this.ddTel=ddTel;
    }

    public String getDaDaType(){
        return DaDaType;
    }

    public void setDaDaType(String DaDaType){
        this.DaDaType = DaDaType;
    }

    public Boolean isAutoEnable() {
        return autoEnable;
    }

    public void setAutoEnable(Boolean autoEnable) {
        this.autoEnable = autoEnable;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Boolean isAutoShipping() {
        return autoShipping;
    }

    public void setAutoShipping(Boolean autoShipping) {
        this.autoShipping = autoShipping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShippingAutoSettingDTO shippingAutoSettingDTO = (ShippingAutoSettingDTO) o;
        if(shippingAutoSettingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shippingAutoSettingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShippingAutoSettingDTO{" +
            "id=" + getId() +
            ", merchantId='" + getMerchantId() + "'" +
            ", bandId='" + getBrandId() + "'" +
            ", autoShipping='" + isAutoShipping() + "'" +
            "}";
    }
}
