package com.cross.merchants.web.rest.VO;

import com.cross.merchants.service.dto.CartItemDTO;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.merchants.service.dto.MerchantsCategoryDTO;
import com.cross.merchants.service.dto.MerchantsCheckInInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/26
 ************************************************************/
@ApiModel(description = "店铺信息")
public class StoreInfoVO implements Serializable {


    private Long id;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;

    /**
     * 店铺名称
     */
    @ApiModelProperty(value = "店铺名称")
    private String storeName;


    @ApiModelProperty(value = "购物车信息")
    private List<CartItemDTO> cartItemDTOS;


    public List<CartItemDTO> getCartItemDTOS() {
        return cartItemDTOS;
    }

    public void setCartItemDTOS(List<CartItemDTO> cartItemDTOS) {
        this.cartItemDTOS = cartItemDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreInfoVO that = (StoreInfoVO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        return storeName != null ? storeName.equals(that.storeName) : that.storeName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        return result;
    }
}
