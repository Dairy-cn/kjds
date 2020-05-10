package com.cross.model;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 马晓林
 * @since 2019/9/26 11:00
 * 购物车同步数据对象
 * 将该对象放入缓存中 以brandid#merchantId#merchantTableId索引
 * 订单提交后 更改购物车状态
 */
public class ShoppingTrolleyDTO implements Serializable {

    /**
     * 标记当前购物车的唯一ID
     */
    @ApiModelProperty("标记当前购物车的唯一ID")
    private String uid;

    /**
     * 平台id
     */
    @ApiModelProperty("平台id")
    private Long platFormId;

    /**
     * 点餐发起人
     */
    @ApiModelProperty("点餐发起人")
    private Long masterUserId;
    /**
     * 购物车商品列表
     */
    @ApiModelProperty("购物车商品列表")
    private CopyOnWriteArrayList<ProductInTrolleyDTO> productInTrolleyDTO;

    /**
     * 商品总价格
     */
    @ApiModelProperty("商品总价格")
    private BigDecimal totalAmount;
    /**
     * 优惠的价格
     */
    @ApiModelProperty("优惠的总价格")
    private BigDecimal reducePrice;

    /**
     * 满减的金额
     */
    @ApiModelProperty("满减的金额")
    private BigDecimal fullReducePrice;

    /**
     * 点餐人
     */
    @ApiModelProperty("点餐人")
    private Map<Long,QROrderPeople> people;

    /**
     * 购物车状态  0 点餐中  1 结束点餐 2 买单完成
     */
    @ApiModelProperty("购物车状态  0 点餐中  1 结束点餐 2 买单完成")
    private Integer status;
    /**
     * 桌台收费状态 0是关闭 1按桌收费 2按人收费
     */
    @ApiModelProperty(value = "桌台收费状态 0是关闭 1按桌收费 2按人收费")
    private Integer feeStatus;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private BigDecimal fee;
    /**
     * 总桌台收费金额
     */
    @ApiModelProperty(value = "金额")
    private BigDecimal TotalFee;
    /**
     * 就餐人数
     */
    private Integer peopleNum;
    /**
     * 桌子可坐人数
     */
    private String limitPeopleNum;

    /**
     * 满减信息
     */
    private ShopFullReductionActivityDTO shopFullReductionActivityDTO;

    private Long createTime;
    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 付款模式  0为餐前 1位餐后
     */
    private Integer payType;

    private Long tableId;
    /**
     * 商品列表
     * @return
     */
    public CopyOnWriteArrayList<ProductInTrolleyDTO> getProductInTrolleyDTO() {
        return productInTrolleyDTO;
    }

    public void setProductInTrolleyDTO(CopyOnWriteArrayList<ProductInTrolleyDTO> productInTrolleyDTO) {
        this.productInTrolleyDTO = productInTrolleyDTO;
    }

    public Integer getPayType() {
        return payType;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getFullReducePrice() {
        return fullReducePrice;
    }

    public void setFullReducePrice(BigDecimal fullReducePrice) {
        this.fullReducePrice = fullReducePrice;
    }

    public ShopFullReductionActivityDTO getShopFullReductionActivityDTO() {
        return shopFullReductionActivityDTO;
    }

    public void setShopFullReductionActivityDTO(ShopFullReductionActivityDTO shopFullReductionActivityDTO) {
        this.shopFullReductionActivityDTO = shopFullReductionActivityDTO;
    }

    public Long getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(Long platFormId) {
        this.platFormId = platFormId;
    }

    public String getLimitPeopleNum() {
        return limitPeopleNum;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShoppingTrolleyDTO{" +
            "uid='" + uid + '\'' +
            ", platFormId=" + platFormId +
            ", masterUserId=" + masterUserId +
            ", productInTrolleyDTO=" + productInTrolleyDTO +
            ", totalAmount=" + totalAmount +
            ", reducePrice=" + reducePrice +
            ", fullReducePrice=" + fullReducePrice +
            ", people=" + people +
            ", status=" + status +
            ", feeStatus=" + feeStatus +
            ", fee=" + fee +
            ", TotalFee=" + TotalFee +
            ", peopleNum=" + peopleNum +
            ", limitPeopleNum='" + limitPeopleNum + '\'' +
            ", shopFullReductionActivityDTO=" + shopFullReductionActivityDTO +
            ", createTime=" + createTime +
            ", orderSn='" + orderSn + '\'' +
            ", payType=" + payType +
            ", tableId=" + tableId +
            '}';
    }

    public void setLimitPeopleNum(String limitPeopleNum) {
        this.limitPeopleNum = limitPeopleNum;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getFeeStatus() {
        return feeStatus;
    }

    public BigDecimal getTotalFee() {
        return TotalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        TotalFee = totalFee;
    }

    public void setFeeStatus(Integer feeStatus) {
        this.feeStatus = feeStatus;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public Long getMasterUserId() {
        return masterUserId;
    }

    public void setMasterUserId(Long masterUserId) {
        this.masterUserId = masterUserId;
    }
    public BigDecimal getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(BigDecimal reducePrice) {
        this.reducePrice = reducePrice;
    }

    public Map<Long,QROrderPeople> getPeople() {
        return people;
    }

    public void setPeople(Map<Long,QROrderPeople> people) {
        this.people = people;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
