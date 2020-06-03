package com.cross.merchants.web.rest.DTO;

import com.cross.merchants.domain.OrderItem;
import com.cross.merchants.domain.PayOrder;
import com.cross.merchants.service.dto.OrderItemDTO;
import com.cross.merchants.service.dto.PayOrderDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/5/24

 ************************************************************/
@ApiModel(description = "订单详情信息")
public class OrderDetail  extends PayOrderDTO {

    @ApiModelProperty("订单商品列表")
    private List<OrderItemDTO> orderItemList;

    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
