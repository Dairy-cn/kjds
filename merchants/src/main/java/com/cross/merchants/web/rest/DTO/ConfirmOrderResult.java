package com.cross.merchants.web.rest.DTO;

import com.cross.merchants.service.dto.StoreOrderResult;
import com.cross.merchants.service.dto.UserAddressDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/5/24
 ************************************************************/
@ApiModel(description = "确认单信息封装")
public class ConfirmOrderResult {


    @ApiModelProperty("用户收货地址列表")
    private List<UserAddressDTO> userAddressDTOS;

    @ApiModelProperty("商品的真实库存（剩余库存-锁定库存）")
    private Integer realStock;

    @ApiModelProperty("计算的金额")
    private CalcAmount calcAmount;

    @ApiModelProperty("确认订单是返回的商户、商品信息")
    private List<StoreOrderResult> orderResults;

    public List<StoreOrderResult> getOrderResults() {
        return orderResults;
    }

    public void setOrderResults(List<StoreOrderResult> orderResults) {
        this.orderResults = orderResults;
    }

    public List<UserAddressDTO> getUserAddressDTOS() {
        return userAddressDTOS;
    }

    public void setUserAddressDTOS(List<UserAddressDTO> userAddressDTOS) {
        this.userAddressDTOS = userAddressDTOS;
    }

    public Integer getRealStock() {
        return realStock;
    }

    public void setRealStock(Integer realStock) {
        this.realStock = realStock;
    }

    public CalcAmount getCalcAmount() {
        return calcAmount;
    }

    public void setCalcAmount(CalcAmount calcAmount) {
        this.calcAmount = calcAmount;
    }

    public static class CalcAmount{
        //订单商品总金额
        @ApiModelProperty("计算的金额")
        private BigDecimal totalAmount;
        @ApiModelProperty("运费")
        private BigDecimal freightAmount;
        @ApiModelProperty("活动优惠")
        private BigDecimal promotionAmount;
        @ApiModelProperty("税费")
        private BigDecimal taxesFees;
        @ApiModelProperty("应付金额")
        private BigDecimal payAmount;

        public BigDecimal getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
        }

        public BigDecimal getFreightAmount() {
            return freightAmount;
        }

        public void setFreightAmount(BigDecimal freightAmount) {
            this.freightAmount = freightAmount;
        }

        public BigDecimal getPromotionAmount() {
            return promotionAmount;
        }

        public void setPromotionAmount(BigDecimal promotionAmount) {
            this.promotionAmount = promotionAmount;
        }

        public BigDecimal getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(BigDecimal payAmount) {
            this.payAmount = payAmount;
        }

        public BigDecimal getTaxesFees() {
            return taxesFees;
        }

        public void setTaxesFees(BigDecimal taxesFees) {
            this.taxesFees = taxesFees;
        }
    }
}
