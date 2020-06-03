package com.cross.merchants.web.rest.DTO;

import java.math.BigInteger;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/27

 ************************************************************/
public class GoodEntity {

    private BigInteger id;

    public GoodEntity(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
}
