package com.cross.model;


import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Refund entity.
 */
public class RefundModel implements Serializable {

    private Long id;

    private Long refundSn;

    @Size(max = 30)
    private String serviceType;

    private String merchantNo;

    @Size(min = 32, max = 32)
    private String tradeNo;

    private Integer totalFee;

    private Integer refundFee;

    private Integer state;

    @Size(max = 16)
    private String refundChannel;

    private Integer addTime;

    @Size(max = 60)
    private String addIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRefundSn() {
        return refundSn;
    }

    public void setRefundSn(Long refundSn) {
        this.refundSn = refundSn;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(String refundChannel) {
        this.refundChannel = refundChannel;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RefundModel refundDTO = (RefundModel) o;
        if(refundDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), refundDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RefundModel{" +
            "id=" + getId() +
            ", refundSn='" + getRefundSn() + "'" +
            ", serviceType='" + getServiceType() + "'" +
            ", merchantNo='" + getMerchantNo() + "'" +
            ", tradeNo='" + getTradeNo() + "'" +
            ", totalFee='" + getTotalFee() + "'" +
            ", refundFee='" + getRefundFee() + "'" +
            ", state='" + getState() + "'" +
            ", refundChannel='" + getRefundChannel() + "'" +
            ", addTime='" + getAddTime() + "'" +
            ", addIp='" + getAddIp() + "'" +
            "}";
    }
}
