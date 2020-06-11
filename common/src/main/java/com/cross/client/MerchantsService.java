package com.cross.client;

import com.cross.DTO.UserOrderCountAndAmountDTO;
import com.cross.config.AuthorizedFeignClient;
import com.cross.model.*;
import com.cross.model.message.MsgContentVM;
import com.cross.model.message.MsgType;
import com.cross.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Component
@AuthorizedFeignClient(name = "merchants")
public interface MerchantsService {
	
	@ApiOperation("根据用户获取消费情况")
	@RequestMapping(value = "/api/get-order-count-amount", method = RequestMethod.GET)
	@ResponseBody
	R<Map<Long, UserOrderCountAndAmountDTO>> getOrderCountAndAmountByUserIds(@RequestParam(value = "userIds") List<Long> userIds);
}
