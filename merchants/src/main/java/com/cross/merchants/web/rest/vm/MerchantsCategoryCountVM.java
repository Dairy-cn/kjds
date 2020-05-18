package com.cross.merchants.web.rest.vm;

import java.math.BigDecimal;
import java.math.BigInteger;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/13
 ************************************************************/
public class MerchantsCategoryCountVM {

    private BigInteger categoryId;

    private BigInteger count;

    public MerchantsCategoryCountVM(BigInteger categoryId, BigInteger count) {
        this.categoryId = categoryId;
        this.count = count;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
}
