package com.cross.model;

import java.io.Serializable;

/**
 * A DTO for the {@link com.cross.merchant.domain.MdmSynMember} entity.
 */
public class MdmSynMemberDTO implements Serializable {

    private Long id;

    /**
     * 第三方唯一标识 我方数据库唯一id
     */
    private String thirdNo;


    /**
     * 平台guid
     */
    private String guid;

    /**
     * 品牌guid
     */
    private String brandGuid;

    /**
     * 门店guid
     */
    private String storeGuid;

    /**
     * 账户
     */
    private String account;

    /**
     * 微信openId
     */
    private String openId;

    /**
     * 会员注册来源 0后台添加,1POS机注册,2一体机注册,3后台导入，20微信关注，21微信扫码点餐，22预定，23排队，24微信注册.25微信C端后台注册
     */
    private Integer sourceType;

    /**
     * 账号状态(0:正常 ， 1：冻结)
     */
    private Integer accountState;

    /**
     * 是否删除
     */
    private Boolean delete;

    /**
     * 会员基本信息表关联标识
     */
    private String memberInfoThirdNo;

    private String memberSerialId;

    /**
     * 手机号码
     */
    private String phoneNum;

    private String unionId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 性别（1 男性，2 女性，0 未知）
     */
    private Integer sex;

    /**
     * 时间pattern = \"yyyy-MM-dd HH:mm:ss\", timezone = \"Asia/Shanghai\"
     */
    private String birthday;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 区编码
     */
    private String areaCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 区名称
     */
    private String areaName;

    /**
     * 用户详细地址
     */
    private String address;

    /**
     * 头像url地址
     */
    private String headImgUrl;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 支付密码
     */
    private String payPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
    }

    public String getBrandGuid() {
        return brandGuid;
    }

    public void setBrandGuid(String brandGuid) {
        this.brandGuid = brandGuid;
    }

    public String getStoreGuid() {
        return storeGuid;
    }

    public void setStoreGuid(String storeGuid) {
        this.storeGuid = storeGuid;
    }

    public String getAccount() {
        return account;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getAccountState() {
        return accountState;
    }

    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public String getMemberInfoThirdNo() {
        return memberInfoThirdNo;
    }

    public void setMemberInfoThirdNo(String memberInfoThirdNo) {
        this.memberInfoThirdNo = memberInfoThirdNo;
    }

    public String getMemberSerialId() {
        return memberSerialId;
    }

    public void setMemberSerialId(String memberSerialId) {
        this.memberSerialId = memberSerialId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    @Override
    public String toString() {
        return "MdmSynMemberDTO{" +
            "id=" + id +
            ", thirdNo='" + thirdNo + '\'' +
            ", brandGuid='" + brandGuid + '\'' +
            ", storeGuid='" + storeGuid + '\'' +
            ", account='" + account + '\'' +
            ", openId='" + openId + '\'' +
            ", sourceType=" + sourceType +
            ", accountState=" + accountState +
            ", delete=" + delete +
            ", memberInfoThirdNo='" + memberInfoThirdNo + '\'' +
            ", memberSerialId='" + memberSerialId + '\'' +
            ", phoneNum='" + phoneNum + '\'' +
            ", unionId='" + unionId + '\'' +
            ", nickName='" + nickName + '\'' +
            ", sex=" + sex +
            ", birthday=" + birthday +
            ", provinceCode='" + provinceCode + '\'' +
            ", cityCode='" + cityCode + '\'' +
            ", areaCode='" + areaCode + '\'' +
            ", provinceName='" + provinceName + '\'' +
            ", cityName='" + cityName + '\'' +
            ", areaName='" + areaName + '\'' +
            ", address='" + address + '\'' +
            ", headImgUrl='" + headImgUrl + '\'' +
            ", occupation='" + occupation + '\'' +
            ", signature='" + signature + '\'' +
            ", password='" + password + '\'' +
            ", payPassword='" + payPassword + '\'' +
            '}';
    }
}
