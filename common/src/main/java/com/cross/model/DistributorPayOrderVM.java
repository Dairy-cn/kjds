package com.cross.model;

import java.math.BigInteger;

/*************************************************************
 * Description:  分销通吃卡订单统计
 * Author: Dair
 * CreateTime: 2019/12/31
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
public class DistributorPayOrderVM {
    
    /**
     * 累计订单数
     */
    private BigInteger totalCount;
    
    /**
     * 累计订单金额
     */
    private Double totalAmoumt;
    
    public DistributorPayOrderVM() {
    }
    
    public DistributorPayOrderVM(BigInteger totalCount, Double totalAmoumt) {
        this.totalCount = totalCount;
        this.totalAmoumt = totalAmoumt;
    }
    
    public BigInteger getTotalCount() {
        return totalCount;
    }
    
    public void setTotalCount(BigInteger totalCount) {
        this.totalCount = totalCount;
    }
    
    public Double getTotalAmoumt() {
        return totalAmoumt;
    }
    
    public void setTotalAmoumt(Double totalAmoumt) {
        this.totalAmoumt = totalAmoumt;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        DistributorPayOrderVM that = (DistributorPayOrderVM) o;
        
        if (totalCount != null ? !totalCount.equals(that.totalCount) : that.totalCount != null) return false;
        return totalAmoumt != null ? totalAmoumt.equals(that.totalAmoumt) : that.totalAmoumt == null;
    
    }
    
    @Override
    public int hashCode() {
        int result = totalCount != null ? totalCount.hashCode() : 0;
        result = 31 * result + (totalAmoumt != null ? totalAmoumt.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "DistributorPayOrderVM{" +
            "totalCount=" + totalCount +
            ", totalAmoumt=" + totalAmoumt +
            '}';
    }
}
