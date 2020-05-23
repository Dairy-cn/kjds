package com.cross.merchants.service.dto;

import com.cross.merchants.domain.GoodsSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import javax.persistence.Column;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.Goods} entity.
 */
@ApiModel(description = "商品信息")
public class GoodsDTO implements Serializable {

    private Long id;

    /**
     * 店铺id
     */
    @NotNull
    @ApiModelProperty(value = "店铺id", required = true)
    private Long storeId;

    @ApiModelProperty(value = "商品编号")
    private String goodsNo;

    /**
     * 品牌id
     */
    @NotNull
    @ApiModelProperty(value = "品牌id", required = true)
    private Long brandId;

    /**
     * 销售模式 1 现货销售
     */
    @NotNull
    @ApiModelProperty(value = "销售模式 1 现货销售", required = true)
    private Integer salesModel;

    /**
     * 商品名称
     */
    @NotNull
    @ApiModelProperty(value = "商品名称", required = true)
    private String goodsName;

    /**
     * 商品描述
     */
    @Size(max = 2000)
    @ApiModelProperty(value = "商品描述")
    private String goodsDesc;

    /**
     * SPU编码
     */
    @ApiModelProperty(value = "SPU编码")
    private String spuNo;

    /**
     * 商品品类id
     */
    @ApiModelProperty(value = "商品品类id")
    private Long categoryId;

    /**
     * 商品运费
     */
    @ApiModelProperty(value = "商品运费")
    private BigDecimal freight;

    /**
     * 商品详情
     */
    @Size(max = 2000)
    @ApiModelProperty(value = "商品详情")
    private String goodsDetails;

    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    private Long proposer;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Instant createTime;
    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    private Instant applicationTime;

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

    /**
     * 商品图片信息
     */
    @ApiModelProperty(value = "商品图片信息")
    private List<String> goodsPic;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean deleteFlag;

    /**
     * 上架状态
     */
    @ApiModelProperty(value = "上架状态")
    private Boolean saleState;

    @ApiModelProperty(value = "商品分类信息")
    private GoodsCategoryDTO goodsCategoryDTO;

    @ApiModelProperty(value = "商品sku")
    private List<GoodsSkuDTO> goodsSkuDTOS;

    @ApiModelProperty(value = "商品属性信息")
    private List<GoodsPropertyDTO> goodsPropertyDTOS;

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public List<GoodsPropertyDTO> getGoodsPropertyDTOS() {
        return goodsPropertyDTOS;
    }

    public void setGoodsPropertyDTOS(List<GoodsPropertyDTO> goodsPropertyDTOS) {
        this.goodsPropertyDTOS = goodsPropertyDTOS;
    }

    public List<GoodsSkuDTO> getGoodsSkuDTOS() {
        return goodsSkuDTOS;
    }

    public void setGoodsSkuDTOS(List<GoodsSkuDTO> goodsSkuDTOS) {
        this.goodsSkuDTOS = goodsSkuDTOS;
    }

    public GoodsCategoryDTO getGoodsCategoryDTO() {
        return goodsCategoryDTO;
    }

    public void setGoodsCategoryDTO(GoodsCategoryDTO goodsCategoryDTO) {
        this.goodsCategoryDTO = goodsCategoryDTO;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public Boolean getSaleState() {
        return saleState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getSalesModel() {
        return salesModel;
    }

    public void setSalesModel(Integer salesModel) {
        this.salesModel = salesModel;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getSpuNo() {
        return spuNo;
    }

    public void setSpuNo(String spuNo) {
        this.spuNo = spuNo;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
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

    public Integer getCheckStatus() {
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

    public List<String> getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(List<String> goodsPic) {
        this.goodsPic = goodsPic;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Boolean isSaleState() {
        return saleState;
    }

    public void setSaleState(Boolean saleState) {
        this.saleState = saleState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GoodsDTO goodsDTO = (GoodsDTO) o;
        if (goodsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), goodsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GoodsDTO{" +
            "id=" + getId() +
            ", storeId=" + getStoreId() +
            ", brandId=" + getBrandId() +
            ", salesModel=" + getSalesModel() +
            ", goodsName='" + getGoodsName() + "'" +
            ", goodsDesc='" + getGoodsDesc() + "'" +
            ", spuNo='" + getSpuNo() + "'" +
            ", categoryId=" + getCategoryId() +
            ", freight=" + getFreight() +
            ", goodsDetails='" + getGoodsDetails() + "'" +
            ", proposer=" + getProposer() +
            ", applicationTime='" + getApplicationTime() + "'" +
            ", checkStatus='" + getCheckStatus() + "'" +
            ", checkFailureReasons='" + getCheckFailureReasons() + "'" +
            ", checkTime='" + getCheckTime() + "'" +
            ", goodsPic='" + getGoodsPic() + "'" +
            ", deleteFlag='" + isDeleteFlag() + "'" +
            ", saleState='" + isSaleState() + "'" +
            "}";
    }
}
