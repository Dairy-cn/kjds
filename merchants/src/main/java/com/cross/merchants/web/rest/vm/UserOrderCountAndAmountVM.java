package com.cross.merchants.web.rest.vm;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Dair
 * @since
 */
public class UserOrderCountAndAmountVM {

    private BigInteger memberId;

    private BigInteger totalOrderCount;


    private BigDecimal totalPayAmount;


    public UserOrderCountAndAmountVM(BigInteger memberId, BigInteger totalOrderCount, BigDecimal totalPayAmount) {
        this.memberId = memberId;
        this.totalOrderCount = totalOrderCount;
        this.totalPayAmount = totalPayAmount;
    }

    public BigInteger getMemberId() {
        return memberId;
    }

    public void setMemberId(BigInteger memberId) {
        this.memberId = memberId;
    }

    public BigInteger getTotalOrderCount() {
        return totalOrderCount;
    }

    public void setTotalOrderCount(BigInteger totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    public BigDecimal getTotalPayAmount() {
        return totalPayAmount;
    }

    public void setTotalPayAmount(BigDecimal totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
    }
}
