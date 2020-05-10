package com.cross.model;

import java.math.BigInteger;

/*************************************************************
 * Description: 
 * Author: Dair
 * CreateTime: 2019/8/30
 ************************************************************/
public class ShopOrderAmountSumVm {


    private BigInteger dishId;


    private String dishName;
    
    private String dishNo;


    private Double totalAmount;
    
    private BigInteger merchantId;


    public ShopOrderAmountSumVm() {
    }
    
    public ShopOrderAmountSumVm(BigInteger dishId, String dishName, Double totalAmount, BigInteger merchantId) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.totalAmount = totalAmount;
        this.merchantId = merchantId;
    }
    
    public ShopOrderAmountSumVm(BigInteger dishId, String dishName, Double totalAmount) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.totalAmount = totalAmount;
    }
    
    public BigInteger getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(BigInteger merchantId) {
        this.merchantId = merchantId;
    }
    
    public BigInteger getDishId() {
        return dishId;
    }

    public void setDishId(BigInteger dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getDishNo() {
        return dishNo;
    }
    
    public void setDishNo(String dishNo) {
        this.dishNo = dishNo;
    }
    
    @Override
    public String toString() {
        return "ShopOrderPriceSumVm{" +
            "dishId=" + dishId +
            ", dishName='" + dishName + '\'' +
            ", totalAmount=" + totalAmount +
            '}';
    }
}
