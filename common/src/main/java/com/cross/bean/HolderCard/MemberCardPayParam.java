package com.cross.bean.HolderCard;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/**
 * 确认支付订单请求参数DTo
 *
 * @author: lc
 * @date: 2020.1.13
 */
@ApiModel(value = "MemberCardPayParam", description = "确认支付订单请求参数DTo")
@Data
public class MemberCardPayParam {

    @ApiModelProperty(value = "消费记录GUID", notes = "有就传")
    private String memberConsumptionGuid;

    @ApiModelProperty(value = "支付信息")
    @Size(min = 1, message = "支付方式必须大于1")
    @NotNull(message = "支付方式必传")
    private List<PayInfoDTO> payInfoDTOList;

    /**
     * 卡余额支付多少
     */
    @ApiModelProperty(value = "卡余额支付多少")
    @NotNull(message = "支付金额不能为空")
    private BigDecimal cardBalancePayAmount;

    @ApiModelProperty(value = "支付密码（余额支付时毕传）")
    private String payPassword;

    @ApiModelProperty(value = "会员GUID")
    @NotBlank(message = "会员GUID不能为空")
    private String memberInfoGuid;

    @ApiModelProperty(value = "会员持卡GUID")
    @NotBlank(message = "会员持卡GUID不能为空")
    private String memberInfoCardGuid;

    @ApiModelProperty(value = "确认支付订单详情DTO")
    @NotNull(message = "订单信息不能为空")
    private OrderInfoReqDTO orderInfoReqDTO;

    @ApiModelProperty(value = "使用的积分，没有传0")
    @NotNull(message = "使用的积分不能为空")
    private Integer useIntegral;

    @ApiModelProperty(value = "积分抵扣了多少钱，，没有抵扣传0")
    @NotNull(message = "积分抵扣了多少钱不能为空")
    private BigDecimal integralDiscountMoney;

    @ApiModelProperty(value = "菜品信息DTO集合")
    private List<DishInfoDTO> dishInfoDTOList;

    @ApiModelProperty(value = "优惠信息")
    private List<DiscountInfoDTO> discountInfoDTOList;
}
