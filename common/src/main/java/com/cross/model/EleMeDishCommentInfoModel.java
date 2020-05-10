package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 * 订单菜品评论信息
 */
public class EleMeDishCommentInfoModel implements Serializable {

    private Long id;

    /**
     * 订单评论id
     */
    private Long orderCommentId;

    /**
     * 菜品评论编号
     */
    private String dishCommentId;
    /**
     * 店铺id
     */
    private String shopId;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 菜品编号
     */
    private String dishId;

    /**
     *  菜品名称
     */
    private String dishName;

    /**
     *  菜品评分
     */
    private Integer dishRating;

    /**
     * 菜品点评时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant dishRatedTime;


    /**
     *  评价内容
     */
    private String rateContent;


    /**
     * 图片URL
     */
    private List<String> picturesUrl;

    /**
     * 订单回复评论id
     */
    private Long eleMeDishCommentReplyId;

    public Long getOrderCommentId() {
        return orderCommentId;
    }

    public void setOrderCommentId(Long orderCommentId) {
        this.orderCommentId = orderCommentId;
    }

    public Integer getDishRating() {
        return dishRating;
    }

    public void setDishRating(Integer dishRating) {
        this.dishRating = dishRating;
    }

    public Instant getDishRatedTime() {
        return dishRatedTime;
    }

    public void setDishRatedTime(Instant dishRatedTime) {
        this.dishRatedTime = dishRatedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishCommentId() {
        return dishCommentId;
    }

    public void setDishCommentId(String dishCommentId) {
        this.dishCommentId = dishCommentId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getRateContent() {
        return rateContent;
    }

    public void setRateContent(String rateContent) {
        this.rateContent = rateContent;
    }

    public List<String> getPicturesUrl() {
        return picturesUrl;
    }

    public void setPicturesUrl(List<String> picturesUrl) {
        this.picturesUrl = picturesUrl;
    }

    public Long getEleMeDishCommentReplyId() {
        return eleMeDishCommentReplyId;
    }

    public void setEleMeDishCommentReplyId(Long eleMeDishCommentReplyId) {
        this.eleMeDishCommentReplyId = eleMeDishCommentReplyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleMeDishCommentInfoModel that = (EleMeDishCommentInfoModel) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EleMeDishCommentInfoDTO{" +
                "id=" + id +
                ", dishCommentId=" + dishCommentId +
                ", merchantId=" + merchantId +
                ", dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishRating=" + dishRating +
                ", dishRatedTime=" + dishRatedTime +
                ", rateContent='" + rateContent + '\'' +
                ", picturesUrl=" + picturesUrl +
                ", eleMeDishCommentReplyId=" + eleMeDishCommentReplyId +
                '}';
    }
}
