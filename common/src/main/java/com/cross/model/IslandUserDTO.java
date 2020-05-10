package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.island.domain} entity.
 */
@ApiModel(description = "用户信息")
public class IslandUserDTO implements Serializable {



    private Long id;


    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id", required = true)
    @NotNull
    private Long platformId;


    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 小程序表id
     */
    @NotNull
    @ApiModelProperty(value = "小程序表id", required = true)
    private Long weappUserId;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String weappUserName;

    /**
     * 用户性别
     */
    @ApiModelProperty(value = "用户性别")
    private Integer sex;

    /**
     * 用户出生日期
     */
    @ApiModelProperty(value = "用户出生日期")
    private LocalDate birthday;

    /**
     * 用户绑定手机号码
     */
    @ApiModelProperty(value = "用户绑定手机号码")
    private String phone;

    /**
     * 余额
     */
    @ApiModelProperty(value = "余额")
    private BigDecimal amount;

    /**
     * 达人昵称
     */
    @ApiModelProperty(value = "达人昵称")
    private String nickName;

    /**
     * 已提现金额
     */
    @ApiModelProperty(value = "已提现金额")
    private BigDecimal withdraw;

    /**
     * 用户等级
     */
    @ApiModelProperty(value = "用户等级")
    private Integer grade;

    /**
     * 用户等级名称
     */
    @ApiModelProperty(value = "用户等级名称")
    private String gradeName;


    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String headPic;

    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime registerTime;

    /**
     * 用户地址
     */
    @ApiModelProperty(value = "用户地址")
    private String address;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    /**
     * 成长值
     */
    @ApiModelProperty(value = "成长值")
    private Integer growthValue;



    /**
     * 状态  1正常 0 锁定
     */
    @ApiModelProperty(value = "状态  1正常 0 锁定")
    private Boolean state;
    /**
     * 微信登录名
     */
    @ApiModelProperty(value = "微信登录名")
    private String weappLogin;


    @ApiModelProperty(value = "接单数")
    private Integer takeCount;


    @ApiModelProperty(value = "获得赏金数")
    private BigDecimal promotionReward;

    @ApiModelProperty(value = "赏金余额")
    private BigDecimal rewardAmount;

    @ApiModelProperty(value = "获得赏金额")
    private BigDecimal distributionReward;

    @ApiModelProperty(value = "已有身份 已有身份 1 达人 2 通吃卡 4通吃俱乐部")
    private Integer identity;




    /**营销中心赏金池活动,参见活动邀请人数统计排名 added by wy at 20190812 start */
    @ApiModelProperty(value = "邀请人(被谁邀请注册)")
    private String inviteUser;

    @ApiModelProperty(value = "邀请总人数")
    private Long invitedNum;

    @ApiModelProperty(value = "通吃卡会员信息")
    private IslandUserMemberDTO islandUserMemberDTO;

    @ApiModelProperty(value = "角色信息")
    private String roles;

    @ApiModelProperty(value = "最后登录时间")
    private String lastLoginDateTime;

    @ApiModelProperty(value = "增加支付密码 该密码仅对mdm会员卡生效 加密方式使用mdm")
    private String payPassword;

    @ApiModelProperty(value = "增加MDM平台guid  使用此id与掌控者会员进行交互")
    private String mdmGuid;

    public String getMdmGuid() {
        return mdmGuid;
    }

    public void setMdmGuid(String mdmGuid) {
        this.mdmGuid = mdmGuid;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(String lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }

    public IslandUserDTO() {
    }

    public IslandUserDTO(Long invitedNum) {
        this.invitedNum = invitedNum;
    }

    /**营销中心赏金池活动,参见活动邀请人数统计排名 added by wy at 20190812 end */



    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getWeappUserId() {
        return weappUserId;
    }

    public void setWeappUserId(Long weappUserId) {
        this.weappUserId = weappUserId;
    }

    public String getWeappUserName() {
        return weappUserName;
    }

    public void setWeappUserName(String weappUserName) {
        this.weappUserName = weappUserName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigDecimal getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(BigDecimal withdraw) {
        this.withdraw = withdraw;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getGrowthValue() {
        return growthValue;
    }

    public void setGrowthValue(Integer growthValue) {
        this.growthValue = growthValue;
    }





    public Boolean isState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getWeappLogin() {
        return weappLogin;
    }

    public void setWeappLogin(String weappLogin) {
        this.weappLogin = weappLogin;
    }



    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public BigDecimal getPromotionReward() {
        return promotionReward;
    }

    public void setPromotionReward(BigDecimal promotionReward) {
        this.promotionReward = promotionReward;
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getInviteUser() {
        return inviteUser;
    }

    public void setInviteUser(String inviteUser) {
        this.inviteUser = inviteUser;
    }

    public Boolean getState() {
        return state;
    }

    public Long getInvitedNum() {
        return invitedNum;
    }

    public void setInvitedNum(Long invitedNum) {
        this.invitedNum = invitedNum;
    }

    public IslandUserMemberDTO getIslandUserMemberDTO() {
        return islandUserMemberDTO;
    }

    public void setIslandUserMemberDTO(IslandUserMemberDTO islandUserMemberDTO) {
        this.islandUserMemberDTO = islandUserMemberDTO;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public BigDecimal getDistributionReward() {
        return distributionReward;
    }

    public void setDistributionReward(BigDecimal distributionReward) {
        this.distributionReward = distributionReward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandUserDTO islandUserDTO = (IslandUserDTO) o;
        if (islandUserDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandUserDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandUserDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", userId='" + userId + '\'' +
            ", weappUserId=" + weappUserId +
            ", weappUserName='" + weappUserName + '\'' +
            ", sex=" + sex +
            ", birthday=" + birthday +
            ", phone='" + phone + '\'' +
            ", amount=" + amount +
            ", nickName='" + nickName + '\'' +
            ", withdraw=" + withdraw +
            ", grade=" + grade +
            ", gradeName='" + gradeName + '\'' +
            ", headPic='" + headPic + '\'' +
            ", registerTime=" + registerTime +
            ", address='" + address + '\'' +
            ", updateTime=" + updateTime +
            ", growthValue=" + growthValue +
            ", state=" + state +
            ", weappLogin='" + weappLogin + '\'' +
            ", takeCount=" + takeCount +
            ", promotionReward=" + promotionReward +
            ", rewardAmount=" + rewardAmount +
            ", distributionReward=" + distributionReward +
            ", identity=" + identity +
            ", inviteUser='" + inviteUser + '\'' +
            ", invitedNum=" + invitedNum +
            ", islandUserMemberDTO=" + islandUserMemberDTO +
            '}';
    }
}
