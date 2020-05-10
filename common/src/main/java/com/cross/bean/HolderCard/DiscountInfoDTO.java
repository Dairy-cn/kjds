package com.cross.bean.HolderCard;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author caizhanxiang
 * @description 折扣信息
 * @date 2019/7/4 14:42
 */
@Data
@ApiModel(value = "DiscountInfoDTO",description = "折扣信息")
public class DiscountInfoDTO {
    @ApiModelProperty(value = "折扣类型优惠类型",
            example = "0-菜品赠送优惠,1-美团代金券,2-会员折扣,3-整单折扣,4-系统省零,5-整单让价,6-积分抵扣,7-优惠券,8-会员价,12-营销活动")
    private Integer discountType;

    @ApiModelProperty(value = "优惠价格")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "优惠码")
    private String discountCode;

    @ApiModelProperty(value = "优惠率")
    private String discountRate;


}
