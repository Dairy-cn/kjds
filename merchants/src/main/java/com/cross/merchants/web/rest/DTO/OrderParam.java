package com.cross.merchants.web.rest.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/5/24
 ************************************************************/
@ApiModel("生成订单时传入的参数")
public class OrderParam implements Serializable {

    @ApiModelProperty("收货地址ID")
    private Long memberReceiveAddressId;


    @ApiModelProperty("支付方式")
    private Integer payType;

    @ApiModelProperty("被选中的购物车商品ID")
    private List<String> cartIds;


    @ApiModelProperty("被选中的购物车商品ID")
    private List<StoreNoteDTO> storeNoteDTOS;


    public List<StoreNoteDTO> getStoreNoteDTOS() {
        return storeNoteDTOS;
    }

    public void setStoreNoteDTOS(List<StoreNoteDTO> storeNoteDTOS) {
        this.storeNoteDTOS = storeNoteDTOS;
    }

    public Long getMemberReceiveAddressId() {
        return memberReceiveAddressId;
    }

    public void setMemberReceiveAddressId(Long memberReceiveAddressId) {
        this.memberReceiveAddressId = memberReceiveAddressId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public List<String> getCartIds() {
        return cartIds;
    }

    public void setCartIds(List<String> cartIds) {
        this.cartIds = cartIds;
    }
}
