package com.cross.model;


import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the OrderWriteOffCode entity.
 */
public class OrderWriteOffCodeDTO implements Serializable {
    
    private Long id;
    
    private Long orderId;
    
    private String orderSn;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant useDate;
    
    private String writeOffCode;
    
    @ApiModelProperty(value = "核销码使用状态")
    private Boolean useState;
    
    private String codeUrl;
    
    @ApiModelProperty(value = "是否结算")
    private Boolean settlement = Boolean.FALSE;
    
    @ApiModelProperty(value = "结算日期")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant settlementDate;
    
    @ApiModelProperty(value = "核销门店id")
    private Long merchantId;
    
    @ApiModelProperty(value = "核销门店名称")
    private String merchantName;
    
    @ApiModelProperty(value = "品牌id")
    private Long brandId;
    
    @ApiModelProperty(value = "平台id")
    private Long platformId;
    
    @ApiModelProperty(value = "外部消费订单的编码")
    private String salesOrderGUID;
    
    @ApiModelProperty(value = "乐玩电子码状态：1未使用； 2已使用；3已过期(如果预约了，没去消费自动过期)；4冻结")
    private Integer leWanCodeStatus;
    
    @ApiModelProperty(value = "乐玩电子码类型：1到店需预约；2快递需预约；3其他平台产品需预约；4到店无需预约；5快递无需预约")
    private Integer leWanCodeType;
    
    @ApiModelProperty(value = "预约链接/365卡券地址或卡密密码")
    private String reserveUrl;
    
    private ShopOrderDTO shopOrderDTO;
    
    public Integer getLeWanCodeStatus() {
        return leWanCodeStatus;
    }
    
    public void setLeWanCodeStatus(Integer leWanCodeStatus) {
        this.leWanCodeStatus = leWanCodeStatus;
    }
    
    public Integer getLeWanCodeType() {
        return leWanCodeType;
    }
    
    public void setLeWanCodeType(Integer leWanCodeType) {
        this.leWanCodeType = leWanCodeType;
    }
    
    public String getReserveUrl() {
        return reserveUrl;
    }
    
    public void setReserveUrl(String reserveUrl) {
        this.reserveUrl = reserveUrl;
    }
    
    public String getSalesOrderGUID() {
        return salesOrderGUID;
    }
    
    public void setSalesOrderGUID(String salesOrderGUID) {
        this.salesOrderGUID = salesOrderGUID;
    }
    
    public ShopOrderDTO getShopOrderDTO() {
        return shopOrderDTO;
    }
    
    public void setShopOrderDTO(ShopOrderDTO shopOrderDTO) {
        this.shopOrderDTO = shopOrderDTO;
    }
    
    public Long getBrandId() {
        return brandId;
    }
    
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    
    public Long getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
    
    public String getMerchantName() {
        return merchantName;
    }
    
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    
    public Boolean getSettlement() {
        return settlement;
    }
    
    public void setSettlement(Boolean settlement) {
        this.settlement = settlement;
    }
    
    public Instant getSettlementDate() {
        return settlementDate;
    }
    
    public void setSettlementDate(Instant settlementDate) {
        this.settlementDate = settlementDate;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderSn() {
        return orderSn;
    }
    
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
    
    public Instant getUseDate() {
        return useDate;
    }
    
    public void setUseDate(Instant useDate) {
        this.useDate = useDate;
    }
    
    public String getWriteOffCode() {
        return writeOffCode;
    }
    
    public void setWriteOffCode(String writeOffCode) {
        this.writeOffCode = writeOffCode;
    }
    
    public Boolean isUseState() {
        return useState;
    }
    
    public void setUseState(Boolean useState) {
        this.useState = useState;
    }
    
    public String getCodeUrl() {
        return codeUrl;
    }
    
    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        OrderWriteOffCodeDTO orderWriteOffCodeDTO = (OrderWriteOffCodeDTO) o;
        if (orderWriteOffCodeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), orderWriteOffCodeDTO.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "OrderWriteOffCodeDTO{" +
            "id=" + getId() +
            ", orderId=" + getOrderId() +
            ", orderSn='" + getOrderSn() + "'" +
            ", useDate='" + getUseDate() + "'" +
            ", writeOffCode='" + getWriteOffCode() + "'" +
            ", useState='" + isUseState() + "'" +
            ", codeUrl='" + getCodeUrl() + "'" +
            "}";
    }
}
