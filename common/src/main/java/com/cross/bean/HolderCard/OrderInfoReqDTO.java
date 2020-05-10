package com.cross.bean.HolderCard;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 确认支付订单详情DTO
 * 
 * @ClassName: OrderInfoReqDTO
 * @Description:描述这个类的作用:
 * @author: yangjie
 * @date: 2019年6月25日 下午1:58:33
 */
@ApiModel(value ="OrderInfoReqDTO",description = "确认支付订单详情DTO")
@Data
public class OrderInfoReqDTO {
	
	@NotNull
	@ApiModelProperty(value="订单实付金额")
	private BigDecimal orderPaymentAmount;
	
	@NotNull
	@ApiModelProperty(value="订单应付金额")
	private BigDecimal orderRealPaymentAmount;
	
	@NotNull
	@ApiModelProperty(value="订单优惠金额")
	private BigDecimal orderDiscountAmount;
	
	@NotNull
	@ApiModelProperty(value="消费类型，0充值，1消费")
	private Integer consumptionType;
	
	@NotNull
	@ApiModelProperty(value="消费时间")
	private Date consumptionTime;
	@NotNull
	@ApiModelProperty(value="订单类型 0堂食 1外卖")
	private Integer orderType;
	
	@ApiModelProperty(value="就餐桌号")
	private String dinnerTableNum;
	
	@NotNull
	@ApiModelProperty(value="下单时间")
	private Date orderTime;
	
	@ApiModelProperty(value="就餐人数")
	private Integer dinnerNum;
	
	@NotNull
	@ApiModelProperty(value="订单来源，0微信，1一体机,2POS")
	private Integer orderSource;
	
	@NotNull
	@ApiModelProperty(value="订单号")
	private String orderNumber;

}
