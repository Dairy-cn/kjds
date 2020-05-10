package com.cross.bean.HolderCard;

import java.math.BigDecimal;

/**
 * @author maxiaolin
 * @date 2020/1/14
 */
public class PayInfoDTO {
    /**
     * 支付金额
     */
   private BigDecimal  payAmount;
    /**
     * 第三方支付码
     */
   private String payCode;
    /**
     * 支付名称
     */
   private String payName;
    /**
     * 支付方式
     * 支付方式，0 现金支付 1聚合支付，2银行卡支付，3卡余额支付 ，4人脸支付 5,自定义
     */
   private Integer payWay;

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }
}
