package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public class CommonCommentModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 超级管理员id
     */
    private Long userId;
    /**
     * 门店id
     */
    private Long merchantId;

    /**
     * 订单id
     */
    private String orderId;
    /**
     * 评论时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant commentTime;
    /**
     * 渠道
     */
    private String orderFrom;

    /**
     * 评分
     */
    private Integer commentScore;

    /**
     * 订单评价内容
     */
    private String commentContent;

    /**
     * 商家回复
     */
    private String merchantReply;

    /**
     * 商家回复id
     */
    private Long replyId;

    /**
     * 评论编号
     */
    private Long commentId;

    /**
     * 是否回复
     */
    private boolean isReply;

    private List<EleMeDishCommentInfoModel> dishInfo;

    private CommonOrderModel orderInfo;

    /**
     * 是否是黑名单用户
     */
    private Boolean userBlack = Boolean.FALSE ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Instant getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Instant commentTime) {
        this.commentTime = commentTime;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getMerchantReply() {
        return merchantReply;
    }

    public void setMerchantReply(String merchantReply) {
        this.merchantReply = merchantReply;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public boolean isReply() {
        return isReply;
    }

    public void setReply(boolean reply) {
        isReply = reply;
    }

    public List<EleMeDishCommentInfoModel> getDishInfo() {
        return dishInfo;
    }

    public void setDishInfo(List<EleMeDishCommentInfoModel> dishInfo) {
        this.dishInfo = dishInfo;
    }

    public CommonOrderModel getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(CommonOrderModel orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Boolean getUserBlack() {
        return userBlack;
    }

    public void setUserBlack(Boolean userBlack) {
        this.userBlack = userBlack;
    }

    @Override
    public String toString() {
        return "CommonCommentModel{" +
            "brandId=" + brandId +
            ", userId=" + userId +
            ", merchantId=" + merchantId +
            ", orderId='" + orderId + '\'' +
            ", commentTime=" + commentTime +
            ", orderFrom='" + orderFrom + '\'' +
            ", commentScore=" + commentScore +
            ", commentContent='" + commentContent + '\'' +
            ", merchantReply='" + merchantReply + '\'' +
            ", replyId=" + replyId +
            ", commentId=" + commentId +
            ", isReply=" + isReply +
            ", dishInfo=" + dishInfo +
            ", orderInfo=" + orderInfo +
            ", userBlack=" + userBlack +
            '}';
    }
}
