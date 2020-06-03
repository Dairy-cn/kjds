package com.cross.merchants.web.rest.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/25
 ************************************************************/
@ApiModel(description = "备注信息")
public class StoreNoteDTO implements Serializable {

    @ApiModelProperty("店铺id")
    private Long storeId;
    @ApiModelProperty("备注信息")
    private String note;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
