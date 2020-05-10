package com.cross.model;

import com.cross.enumtype.OrderChannelTypeEnum;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author DuYuLiang on 2017/11/10.
 */
public class ShopOrderPrintContent {
    private OrderChannelTypeEnum orderSource; // 订单来源
    private String slogan; // 宣传语
    private String daySn; //当日序号
    private String shopOrderSn; //订单编号
    private String shopName; //店铺名称
    private String userConsignee; //收货人
    private String userAddress; //地址
    private String userMobile; //电话
    private String notice; //备注
    private String total; //总计
    private String packFee; //打包费
    private String shippingFee; //配送费
    private String activityTotal; //优惠
    private String orderDate; //下单日期
    private String receiveDate; //收货时间
    private String orderType;// 订单类型 订单类型 NETWORK 网络外卖,EATNOW 堂吃订单, PICK_UP 自取
    private List<Product> productList;
    private Product product;
    private String tableFee;
    private String tableName;
    private String mealNumber;
    private Integer peopleNum;
    /**
     * 支付方式 1 支付宝 2 微信 3 银行卡 4余额支付  5.免支付
     */
    @ApiModelProperty(value = "支付方式")
    private Integer payWay;
    @ApiModelProperty(value = "交易单号")
    private String paymentOrderCode;
    /**
     * 消费者编号
     */
    @ApiModelProperty(value = "消费者编号", required = true)
    private Long consumerId;
    private String url;

    public String getActivityTotal() {
        return activityTotal;
    }

    public void setActivityTotal(String activityTotal) {
        this.activityTotal = activityTotal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }

    public void setPaymentOrderCode(String paymentOrderCode) {
        this.paymentOrderCode = paymentOrderCode;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public String getTableFee() {
        return tableFee;
    }

    public void setTableFee(String tableFee) {
        this.tableFee = tableFee;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getMealNumber() {
        return mealNumber;
    }

    public void setMealNumber(String mealNumber) {
        this.mealNumber = mealNumber;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getUserConsignee() {
        return userConsignee;
    }

    public void setUserConsignee(String userConsignee) {
        this.userConsignee = userConsignee;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getShopOrderSn() {
        return shopOrderSn;
    }

    public void setShopOrderSn(String shopOrderSn) {
        this.shopOrderSn = shopOrderSn;
    }

    public String getDaySn() {
        return daySn;
    }

    public void setDaySn(String daySn) {
        this.daySn = daySn;
    }

    public Product getProduct() {
        return new Product();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPackFee() {
        return packFee;
    }

    public void setPackFee(String packFee) {
        this.packFee = packFee;
    }

    public String getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public OrderChannelTypeEnum getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(OrderChannelTypeEnum orderSource) {
        this.orderSource = orderSource;
    }
    
    public ShopOrderPrintContent() {
    }
    
    
    @Override
    public String toString() {
        return "ShopOrderPrintContent{" +
            "orderSource=" + orderSource +
            ", slogan='" + slogan + '\'' +
            ", daySn='" + daySn + '\'' +
            ", shopOrderSn='" + shopOrderSn + '\'' +
            ", shopName='" + shopName + '\'' +
            ", userConsignee='" + userConsignee + '\'' +
            ", userAddress='" + userAddress + '\'' +
            ", userMobile='" + userMobile + '\'' +
            ", notice='" + notice + '\'' +
            ", total='" + total + '\'' +
            ", packFee='" + packFee + '\'' +
            ", shippingFee='" + shippingFee + '\'' +
            ", activityTotal='" + activityTotal + '\'' +
            ", orderDate='" + orderDate + '\'' +
            ", receiveDate='" + receiveDate + '\'' +
            ", orderType='" + orderType + '\'' +
            ", productList=" + productList +
            ", product=" + product +
            ", tableFee='" + tableFee + '\'' +
            ", tableName='" + tableName + '\'' +
            ", mealNumber='" + mealNumber + '\'' +
            ", peopleNum=" + peopleNum +
            ", payWay=" + payWay +
            ", paymentOrderCode='" + paymentOrderCode + '\'' +
            ", consumerId=" + consumerId +
            ", url='" + url + '\'' +
            '}';
    }
    
    public class Product {
        private String name;
        private String price;
        private String num;
        private String total;
        /**
         * 菜品名称 1：套餐名  2：套餐详细信息
         */
        private String type = "1";

        public Product() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    
        @Override
        public String toString() {
            return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                ", total='" + total + '\'' +
                ", type='" + type + '\'' +
                '}';
        }
    }
}
