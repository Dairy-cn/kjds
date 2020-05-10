package com.cross.model;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the MerchantPrinter entity.
 */
public class MerchantPrinterModel implements Serializable {

    private Long id;

    @ApiModelProperty(value = "商户编号")
    private Long merchantId;

    @ApiModelProperty(value = "打印机类型")
    private String printerType;

    @ApiModelProperty(value = "打印机序号")
    @Size(max = 20)
    private String printerSn;

    @ApiModelProperty(value = "打印机密钥")
    @Size(max = 32)
    private String printerKey;

    @ApiModelProperty(value = "打印联数")
    private Integer printerNum;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "关联产品分类")
    private Long productCatId;

    @ApiModelProperty(value = "打印机标签")
    @Size(max = 60)
    private String tag;

    @ApiModelProperty(value = "宣传语")
    @Size(max = 255)
    private String slogan;

    @ApiModelProperty(value = "是否打印价格")
    private Boolean printPrice;

    @ApiModelProperty(value = "打印机类型 1 后厨 2 前台")
    private String type;

    @ApiModelProperty(value = "二维码地址")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean isPrintPrice() {
        return printPrice;
    }

    public void setPrintPrice(Boolean printPrice) {
        this.printPrice = printPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    public String getPrinterSn() {
        return printerSn;
    }

    public void setPrinterSn(String printerSn) {
        this.printerSn = printerSn;
    }

    public String getPrinterKey() {
        return printerKey;
    }

    public void setPrinterKey(String printerKey) {
        this.printerKey = printerKey;
    }

    public Integer getPrinterNum() {
        return printerNum;
    }

    public void setPrinterNum(Integer printerNum) {
        this.printerNum = printerNum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductCatId() {
        return productCatId;
    }

    public void setProductCatId(Long productCatId) {
        this.productCatId = productCatId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MerchantPrinterModel merchantPrinterDTO = (MerchantPrinterModel) o;
        if(merchantPrinterDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), merchantPrinterDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MerchantPrinterModel{" +
            "id=" + getId() +
            ", merchantId='" + getMerchantId() + "'" +
            ", printerType='" + getPrinterType() + "'" +
            ", printerSn='" + getPrinterSn() + "'" +
            ", printerKey='" + getPrinterKey() + "'" +
            ", printerNum='" + getPrinterNum() + "'" +
            ", userId='" + getUserId() + "'" +
            ", productCatId='" + getProductCatId() + "'" +
            ", tag='" + getTag() + "'" +
            "}";
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
