package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.Brand} entity.
 */
@ApiModel(description = "店铺品牌信息")
public class BrandDTO implements Serializable {

    private Long id;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    /**
     * 副品牌名称
     */
    @ApiModelProperty(value = "副品牌名称")
    private String brandNameSecond;

    /**
     * 品牌国家地区id
     */
    @ApiModelProperty(value = "品牌国家地区id")
    private Long brandCountryId;

    /**
     * logo
     */
    @ApiModelProperty(value = "logo")
    private String brandLogo;


    /**
     * 品牌编号
     */
    @ApiModelProperty(value = "品牌编号")
    private String brandNo;


    /**
     * 商标注册证
     */
    @ApiModelProperty(value = "商标注册证")
    private List<String> tradeMarkRegistrationPic;

    /**
     * 资质有效期开始时间
     */
    @ApiModelProperty(value = "资质有效期开始时间 yyyy-mm-dd")
    private String certificateValidStartTime;

    /**
     * 资质有效期结束时间
     */
    @ApiModelProperty(value = "资质有效期结束时间 yyyy-mm-dd")
    private String certificateValidEndTime;

    /**
     * 品牌描述
     */
    @ApiModelProperty(value = "品牌描述")
    private String brandDesc;

    /**
     * 供应商代理等级  0 品牌方 1 一级代理 2 二级代理 3  三级代理
     */
    @ApiModelProperty(value = "供应商代理等级  0 品牌方 1 一级代理 2 二级代理 3  三级代理")
    private Integer brandAuthType;

    /**
     * 一级授权书信息
     */
    @ApiModelProperty(value = "一级授权书信息")
    private OwerOfAttorneyDTO owerOfAttorneyPicLevelOne;
    /**
     * 二级授权书信息
     */
    @ApiModelProperty(value = "二级授权书信息")
    private OwerOfAttorneyDTO owerOfAttorneyPicLevelTwo;
    /**
     * 三级授权书信息
     */
    @ApiModelProperty(value = "三级授权书信息")
    private OwerOfAttorneyDTO owerOfAttorneyPicLevelThree;

    /**
     * 审核状态 -1 未审核 0 未通过  1 通过
     */
    @ApiModelProperty(value = "审核状态 -1 未审核 0 未通过  1 通过")
    private Integer checkStatus;

    /**
     * 审核失败原因
     */
    @ApiModelProperty(value = "审核失败原因")
    private String checkFailureReasons;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private Instant checkTime;

    @ApiModelProperty(value = "店铺id")
    @NotNull(message = "店铺id不能为空")
    private Long storeId;

    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    private Long proposer;

    /**
     * 申请人账号
     */
    @ApiModelProperty(value = "申请人账号")
    private String  proposerUserName;

    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    private Instant applicationTime;

    /**
     * 品牌国家地区
     */
    @ApiModelProperty(value = "品牌国家地区")
    private String brandCountry;

    @ApiModelProperty(value = "品牌商品信息",hidden = true)
    private List<GoodsDTO> goodsDTOS;

    @ApiModelProperty(value = "企业信息",hidden = true)
    private EnterpriseInfoDTO enterpriseInfoDTO;


    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Instant creatTime;


    @ApiModelProperty(value = "商户信息",hidden = true)
    private MerchantsCheckInInfoDTO merchantsCheckInInfoDTO;


    public Instant getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Instant creatTime) {
        this.creatTime = creatTime;
    }
    public MerchantsCheckInInfoDTO getMerchantsCheckInInfoDTO() {
        return merchantsCheckInInfoDTO;
    }

    public void setMerchantsCheckInInfoDTO(MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) {
        this.merchantsCheckInInfoDTO = merchantsCheckInInfoDTO;
    }

    public EnterpriseInfoDTO getEnterpriseInfoDTO() {
        return enterpriseInfoDTO;
    }

    public void setEnterpriseInfoDTO(EnterpriseInfoDTO enterpriseInfoDTO) {
        this.enterpriseInfoDTO = enterpriseInfoDTO;
    }

    public String getProposerUserName() {
        return proposerUserName;
    }

    public void setProposerUserName(String proposerUserName) {
        this.proposerUserName = proposerUserName;
    }

    public String getBrandNo() {
        return brandNo;
    }

    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo;
    }

    public List<GoodsDTO> getGoodsDTOS() {
        return goodsDTOS;
    }

    public void setGoodsDTOS(List<GoodsDTO> goodsDTOS) {
        this.goodsDTOS = goodsDTOS;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }

    public Long getProposer() {
        return proposer;
    }

    public void setProposer(Long proposer) {
        this.proposer = proposer;
    }

    public Instant getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Instant applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandNameSecond() {
        return brandNameSecond;
    }

    public void setBrandNameSecond(String brandNameSecond) {
        this.brandNameSecond = brandNameSecond;
    }

    public Long getBrandCountryId() {
        return brandCountryId;
    }

    public void setBrandCountryId(Long brandCountryId) {
        this.brandCountryId = brandCountryId;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public List<String> getTradeMarkRegistrationPic() {
        return tradeMarkRegistrationPic;
    }

    public void setTradeMarkRegistrationPic(List<String> tradeMarkRegistrationPic) {
        this.tradeMarkRegistrationPic = tradeMarkRegistrationPic;
    }

    public String getCertificateValidStartTime() {
        return certificateValidStartTime;
    }

    public void setCertificateValidStartTime(String certificateValidStartTime) {
        this.certificateValidStartTime = certificateValidStartTime;
    }

    public String getCertificateValidEndTime() {
        return certificateValidEndTime;
    }

    public void setCertificateValidEndTime(String certificateValidEndTime) {
        this.certificateValidEndTime = certificateValidEndTime;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public Integer getBrandAuthType() {
        return brandAuthType;
    }

    public void setBrandAuthType(Integer brandAuthType) {
        this.brandAuthType = brandAuthType;
    }

    public OwerOfAttorneyDTO getOwerOfAttorneyPicLevelOne() {
        return owerOfAttorneyPicLevelOne;
    }

    public void setOwerOfAttorneyPicLevelOne(OwerOfAttorneyDTO owerOfAttorneyPicLevelOne) {
        this.owerOfAttorneyPicLevelOne = owerOfAttorneyPicLevelOne;
    }

    public OwerOfAttorneyDTO getOwerOfAttorneyPicLevelTwo() {
        return owerOfAttorneyPicLevelTwo;
    }

    public void setOwerOfAttorneyPicLevelTwo(OwerOfAttorneyDTO owerOfAttorneyPicLevelTwo) {
        this.owerOfAttorneyPicLevelTwo = owerOfAttorneyPicLevelTwo;
    }

    public OwerOfAttorneyDTO getOwerOfAttorneyPicLevelThree() {
        return owerOfAttorneyPicLevelThree;
    }

    public void setOwerOfAttorneyPicLevelThree(OwerOfAttorneyDTO owerOfAttorneyPicLevelThree) {
        this.owerOfAttorneyPicLevelThree = owerOfAttorneyPicLevelThree;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public Integer isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckFailureReasons() {
        return checkFailureReasons;
    }

    public void setCheckFailureReasons(String checkFailureReasons) {
        this.checkFailureReasons = checkFailureReasons;
    }

    public Instant getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Instant checkTime) {
        this.checkTime = checkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BrandDTO brandDTO = (BrandDTO) o;
        if (brandDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), brandDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
            "id=" + id +
            ", brandName='" + brandName + '\'' +
            ", brandNameSecond='" + brandNameSecond + '\'' +
            ", brandCountryId=" + brandCountryId +
            ", brandLogo='" + brandLogo + '\'' +
            ", tradeMarkRegistrationPic=" + tradeMarkRegistrationPic +
            ", certificateValidStartTime='" + certificateValidStartTime + '\'' +
            ", certificateValidEndTime='" + certificateValidEndTime + '\'' +
            ", brandDesc='" + brandDesc + '\'' +
            ", brandAuthType=" + brandAuthType +
            ", owerOfAttorneyPicLevelOne=" + owerOfAttorneyPicLevelOne +
            ", owerOfAttorneyPicLevelTwo=" + owerOfAttorneyPicLevelTwo +
            ", owerOfAttorneyPicLevelThree=" + owerOfAttorneyPicLevelThree +
            ", checkStatus=" + checkStatus +
            ", checkFailureReasons='" + checkFailureReasons + '\'' +
            ", checkTime=" + checkTime +
            ", storeId=" + storeId +
            ", proposer=" + proposer +
            ", applicationTime=" + applicationTime +
            ", brandCountry='" + brandCountry + '\'' +
            '}';
    }
}
