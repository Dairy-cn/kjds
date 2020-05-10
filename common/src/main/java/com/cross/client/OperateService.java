package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.*;
import com.cross.enumtype.OrderChannelTypeEnum;
import com.cross.model.CommonCommentModel;
import com.cross.model.CommonOrderDTO;
import com.cross.model.EmployeeDTO;
import com.cross.model.ShippingAutoSettingDTO;
import com.cross.model.dish.ShopDishSku;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author LY 2018-03-23
 */
@Component
@AuthorizedFeignClient(name = "operation")
public interface OperateService {

    @PostMapping("/api/dada-shipping/shop-add")
    Map<String, Object> createDadaShop(Map<String, Object> shopInfo);

    @PostMapping("/api/shipping-auto-settings")
    ShippingAutoSettingDTO createShippingAutoSetting(ShippingAutoSettingDTO shippingAutoSettingDTO);

    @PostMapping("/api/shop-dish-skus")
    ShopDishSku createShopDishSku(ShopDishSku shopDishSku);

    @GetMapping("/api/employees-by-account/{userId}")
    EmployeeDTO getEmployeeByAccount(@PathVariable("userId") Long userId, @RequestParam("account") String account);

    @GetMapping("/api/employees/{id}")
    EmployeeDTO getEmployeeById(@PathVariable("id") Long userId);

    @PostMapping("/api/common-orders")
    CommonOrderDTO createCommonOrder(CommonOrderDTO commonOrderDTO);

    @PutMapping("api/common-orders")
    CommonOrderDTO updateCommonOrder(CommonOrderDTO commonOrderDTO);

    /**
     * 通过订单号查询公共订单
     *
     * @param orderSn
     * @return
     */
    @GetMapping("api/get-common-order-by-orderSn")
    CommonOrderDTO getCommonOrderByOrderSn(@RequestParam("orderSn") String orderSn);

    @PutMapping("/api/common-orders/status")
    void updateCommonOrderStatus(CommonOrderDTO commonOrderDTO);

    @PutMapping("api/update-user-black")
    void updetaUserBlack(@PathVariable("orderList") List<Long> orderList, @PathVariable("userBlack") Boolean userBlack);

    @PutMapping("api/save-comment")
    void saveCommonComment(@RequestBody CommonCommentModel commonCommentModel);

    @GetMapping("api/find-one-by-id")
    CommonCommentModel findOneById(@RequestParam("id") Long id);

    @PostMapping("api/save-shop-sales")
    void saveShopSales(@RequestBody ShopSalesDTO shopSalesList);

    /**
     * 打印公共订单
     *
     * @param id
     * @return
     */
    @GetMapping("api/common-orders/print-phone")
    void print(@RequestParam("id") Long id, @RequestParam(value = "channel", required = false) OrderChannelTypeEnum channel);

    /**
     * 自动创建美团配送订单
     *
     * @param orderSn
     * @return
     */
    @GetMapping("api/auto-send-mt-shipping-order")
    Map<String, String> autoSendMtShippingOrder(@RequestParam("orderSn") String orderSn);

    @GetMapping("api/cancel-mt-shipping")
    Map<String, Object> cancelMeiTuanShippingOrder(@RequestParam("cancelReason") String cancelReason, @RequestParam("orderSn") String orderSn);

    @GetMapping("api/get-shipping-order-by-order-sn")
    ShopOrderShippingDTO getShippingOrderByOrderSn(@RequestParam("orderSn") String orderSn);
}
