package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.IslandFreeLunchStatusType;
import com.cross.model.enumeration.IslandFreeLunchUserIdentity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 */
@ApiModel(description = "霸王餐活动参加用户记录表")
public class IslandFreeLunchUserInfoDTO implements Serializable {

    private Long id;

    /**
     * 平台编号
     */
    @ApiModelProperty(value = "平台编号")
    private Long platFormId;

    /**
     * 对应霸王餐活动id
     */
    @ApiModelProperty(value = "对应霸王餐活动id")
    private Long islandFreeLunchId;

    /**
     * 对应霸王餐活动名称
     */
    @ApiModelProperty(value = "对应霸王餐活动名称")
    private String islandFreeLunchName;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 小程序表用户id
     */
    @ApiModelProperty(value = "小程序表用户id")
    private Long weappUserId;
    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String headPic;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String userName;

    /**
     * 用户等级
     */
    @ApiModelProperty(value = "用户等级")
    private Integer userLevel;

    /**
     * 用户等级中文
     */
    @ApiModelProperty(value = "用户等级中文")
    private String userLevelName;

    /**
     * 是否认证达人
     */
    @ApiModelProperty(value = "是否认证达人")
    private Boolean ifUserPromotionExpertAuth;

    /**
     * 是否通吃岛会员
     */
    @ApiModelProperty(value = "是否通吃岛会员")
    private Boolean ifUserMember;

    /**
     * 用户所属身份所占中奖份额
     * 如果该用户达到等级又是合伙人或通吃卡会员，该用户的中奖概率需加上身份的比例
     */
    @ApiModelProperty(value = "用户所属身份所占中奖份额")
    private Integer userRatio;

    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    private String mobile;

    /**
     * 报名时间
     */
    @ApiModelProperty(value = "报名时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 活动状态
     */
    @ApiModelProperty(value = "活动状态")
    private IslandFreeLunchStatusType status;

    /**
     * 获取各等级中奖总人数  (抽奖时用)
     * */
    private Integer totalNum;
    /**
     * 订单编号
     */
//    @Size(max = 32)
    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    /**
     * 是否已查看中奖纪录 0未查看 1已查看
     */
    @ApiModelProperty(value = "是否已查看中奖纪录")
    private Integer view;

    /**
     * 体验状态 0未体验 1 已体验
     */
    @ApiModelProperty(value = "体验状态")
    private Integer useStatus;

    /**
     * 对应的霸王餐信息
     */
    @ApiModelProperty(value = "对应的霸王餐信息")
    private IslandFreeLunchDTO islandFreeLunchDTO;

    /**
     * 对应的霸王餐商品图片信息
     */
    @ApiModelProperty(value = "对应的霸王餐商品图片信息")
    private String picture;


    /**
     * 对应的霸王餐商品消费类型  1 物流到家 2 到店消费
     */
    @ApiModelProperty(value = "对应的霸王餐商品消费类型  1 物流到家 2 到店消费")
    private Integer productType;

    /**
     * 霸王餐活动参加人总数
     */
    @ApiModelProperty(value = "霸王餐活动参加人总数")
    private Long totalJoinNum;

    /**
     * 霸王餐活动中奖总人数
     */
    @ApiModelProperty(value = "霸王餐活动中奖总人数")
    private Long winNum;

    /**  霸王餐优化添加字段 20191009 start   */
    /**
     *用户身份
     * */
    @ApiModelProperty(value = "用户身份 认证达人:ISLAND_FREE_LUNCH_PROMOTIONEXPERTAUTH,通吃卡会员:ISLAND_FREE_LUNCH_USERMEMBER")
    private List<IslandFreeLunchUserIdentity> islandFreeLunchUserIdentity;
    /**  霸王餐优化添加字段 20191009 end   */

    public IslandFreeLunchUserInfoDTO(Long totalJoinNum, Long winNum) {
        this.totalJoinNum = totalJoinNum;
        this.winNum = winNum;
    }

    public Long getWeappUserId() {
        return weappUserId;
    }

    public void setWeappUserId(Long weappUserId) {
        this.weappUserId = weappUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(Long platFormId) {
        this.platFormId = platFormId;
    }

    public Long getIslandFreeLunchId() {
        return islandFreeLunchId;
    }

    public void setIslandFreeLunchId(Long islandFreeLunchId) {
        this.islandFreeLunchId = islandFreeLunchId;
    }

    public String getIslandFreeLunchName() {
        return islandFreeLunchName;
    }

    public void setIslandFreeLunchName(String islandFreeLunchName) {
        this.islandFreeLunchName = islandFreeLunchName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Boolean getIfUserPromotionExpertAuth() {
        return ifUserPromotionExpertAuth;
    }

    public void setIfUserPromotionExpertAuth(Boolean ifUserPromotionExpertAuth) {
        this.ifUserPromotionExpertAuth = ifUserPromotionExpertAuth;
    }

    public Boolean getIfUserMember() {
        return ifUserMember;
    }

    public void setIfUserMember(Boolean ifUserMember) {
        this.ifUserMember = ifUserMember;
    }

    public Integer getUserRatio() {
        return userRatio;
    }

    public void setUserRatio(Integer userRatio) {
        this.userRatio = userRatio;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public IslandFreeLunchStatusType getStatus() {
        return status;
    }

    public void setStatus(IslandFreeLunchStatusType status) {
        this.status = status;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public IslandFreeLunchDTO getIslandFreeLunchDTO() {
        return islandFreeLunchDTO;
    }

    public void setIslandFreeLunchDTO(IslandFreeLunchDTO islandFreeLunchDTO) {
        this.islandFreeLunchDTO = islandFreeLunchDTO;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Long getTotalJoinNum() {
        return totalJoinNum;
    }

    public void setTotalJoinNum(Long totalJoinNum) {
        this.totalJoinNum = totalJoinNum;
    }

    public Long getWinNum() {
        return winNum;
    }

    public void setWinNum(Long winNum) {
        this.winNum = winNum;
    }


    public String getUserLevelName() {
        return userLevelName;
    }

    public void setUserLevelName(String userLevelName) {
        this.userLevelName = userLevelName;
    }

    public List<IslandFreeLunchUserIdentity> getIslandFreeLunchUserIdentity() {
        return islandFreeLunchUserIdentity;
    }

    public void setIslandFreeLunchUserIdentity(List<IslandFreeLunchUserIdentity> islandFreeLunchUserIdentity) {
        this.islandFreeLunchUserIdentity = islandFreeLunchUserIdentity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandFreeLunchUserInfoDTO islandFreeLunchUserInfoDTO = (IslandFreeLunchUserInfoDTO) o;
        if (islandFreeLunchUserInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandFreeLunchUserInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public IslandFreeLunchUserInfoDTO() {
    }

    public IslandFreeLunchUserInfoDTO(Integer totalNum, Integer userRatio) {
        this.totalNum = totalNum;
        this.userRatio = userRatio;
    }

    @Override
    public String toString() {
        return "IslandFreeLunchUserInfoDTO{" +
            "id=" + id +
            ", platFormId=" + platFormId +
            ", islandFreeLunchId=" + islandFreeLunchId +
            ", islandFreeLunchName='" + islandFreeLunchName + '\'' +
            ", userId=" + userId +
            ", weappUserId=" + weappUserId +
            ", headPic='" + headPic + '\'' +
            ", userName='" + userName + '\'' +
            ", userLevel=" + userLevel +
            ", userLevelName='" + userLevelName + '\'' +
            ", ifUserPromotionExpertAuth=" + ifUserPromotionExpertAuth +
            ", ifUserMember=" + ifUserMember +
            ", userRatio=" + userRatio +
            ", mobile='" + mobile + '\'' +
            ", createTime=" + createTime +
            ", status=" + status +
            ", totalNum=" + totalNum +
            ", orderSn='" + orderSn + '\'' +
            ", view=" + view +
            ", useStatus=" + useStatus +
            ", islandFreeLunchDTO=" + islandFreeLunchDTO +
            ", picture='" + picture + '\'' +
            ", productType=" + productType +
            ", totalJoinNum=" + totalJoinNum +
            ", winNum=" + winNum +
            ", islandFreeLunchUserIdentity=" + islandFreeLunchUserIdentity +
            '}';
    }
}
