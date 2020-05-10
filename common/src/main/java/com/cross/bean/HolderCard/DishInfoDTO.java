package com.cross.bean.HolderCard;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author caizhanxiang
 * @description 菜品信息
 * @date 2019/6/21 13:55
 */
@Data
@ApiModel(value = "DishInfoDTO",description = "菜品信息")
@Accessors(chain = true)
public class DishInfoDTO {

    @ApiModelProperty(value = "通菜品区别唯一性")
    private String orderItemGuid;

    @ApiModelProperty(value = "菜品guid",required = true)
    @NotBlank(message ="菜品guid 不能为空" )
    private String dishGuid;

    @ApiModelProperty(value = "菜品名称",required = true)
    @NotBlank(message ="菜品名称 不能为空" )
    private String dishName;

    @ApiModelProperty(value = "菜品规格",required = true)
    @NotBlank(message ="菜品规格 不能为空" )
    private String dishSpecification;


    @ApiModelProperty(value = "菜品单位",required = true)
    @NotBlank(message ="菜品单位 不能为空" )
    private String dishUnit;


    @ApiModelProperty(value = "菜品数量",required = true)
    @DecimalMin(value = "0.001",message = "菜品数量 必须大于0.001")
    private BigDecimal dishNum;

    @ApiModelProperty(value = "赠品数量",required = true)
    private BigDecimal giftDishNum;

    @ApiModelProperty(value = "菜品售卖单价",required = true)
    @NotNull(message = "菜品售卖单价 不能为空")
    private BigDecimal dishSellUnitPrice;

    @ApiModelProperty(value = "主商品guid")
    private String mainGoodGuid;


    @ApiModelProperty(value = "是否为主商品,1 是，0 否")
    @NotNull(message = "是否为主商品 不能为空")
    private Integer isMainGood;


    @ApiModelProperty(value = "商品附加费",required = true)
    @NotNull(message = "商品附加费 不能为空")
    private BigDecimal surcharge;


    @ApiModelProperty(value = "商品备注")
    private String remark;

    @ApiModelProperty(value = "商品类型（0-单品 1-套餐）",required = true)
    @NotNull(message = "商品类型 不能为空")
    private Integer dishType;

    @ApiModelProperty(value = "小计",required = true)
    @DecimalMin(value = "0.00",message = "小计 不能为空")
    private BigDecimal subtotal;

    @ApiModelProperty(value = " 支付价格",required = true)
    @DecimalMin(value = "0.00",message = "支付价格 不能为空")
    private BigDecimal payPrice;

    @ApiModelProperty(value = " 优惠的价格")
    private BigDecimal discountMoney;

    @ApiModelProperty(value = " 菜品原单价",required = true)
    @NotNull(message = "菜品原单价 不能为空")
    private BigDecimal dishOriginalUnitPrice;

    @ApiModelProperty(value = "菜品会员价")
    private BigDecimal dishMemberPrice;

    @ApiModelProperty(value = "商品券抵扣菜品数量")
    private BigDecimal productItemNum;
}
