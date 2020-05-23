package com.cross.merchants.domain;


import com.cross.merchants.service.dto.GoodsCategoryDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * 商品信息
 */
@Entity
@Table(name = "goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 店铺id
     */
    @NotNull
    @Column(name = "store_id", nullable = false)
    private Long storeId;

    @Column(name = "goods_no")
    private String goodsNo;

    /**
     * 品牌id
     */
    @NotNull
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    /**
     * 销售模式 1 现货销售
     */
    @NotNull
    @Column(name = "sales_model", nullable = false)
    private Integer salesModel;

    /**
     * 商品名称
     */
    @NotNull
    @Column(name = "goods_name", nullable = false)
    private String goodsName;

    /**
     * 商品描述
     */
    @Size(max = 2000)
    @Column(name = "goods_desc", length = 2000)
    private String goodsDesc;

    /**
     * SPU编码
     */
    @Column(name = "spu_no")
    private String spuNo;

    /**
     * 商品品类id
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 商品运费
     */
    @Column(name = "freight", precision = 21, scale = 2)
    private BigDecimal freight;

    /**
     * 商品详情
     */
    @Size(max = 2000)
    @Column(name = "goods_details", length = 2000)
    private String goodsDetails;

    /**
     * 申请人
     */
    @Column(name = "proposer")
    private Long proposer;

    /**
     * 申请时间
     */
    @Column(name = "application_time")
    private Instant applicationTime;

    /**
     * 审核状态 -1 未审核 0 未通过  1 通过
     */
    @Column(name = "check_status")
    private Integer checkStatus;

    /**
     * 审核失败原因
     */
    @Column(name = "check_failure_reasons")
    private String checkFailureReasons;

    /**
     * 审核时间
     */
    @Column(name = "check_time")
    private Instant checkTime;

    /**
     * 商品图片信息
     */
    @Column(name = "goods_pic")
    private String goodsPic;

    /**
     * 是否删除
     */
    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    /**
     * 上架状态
     */
    @Column(name = "sale_state")
    private Boolean saleState;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Instant createTime;




    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public Instant getCreateTime() {
        return createTime;
    }
    public Goods createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }
    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
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

    public Goods storeId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Goods brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getSalesModel() {
        return salesModel;
    }

    public Goods salesModel(Integer salesModel) {
        this.salesModel = salesModel;
        return this;
    }

    public void setSalesModel(Integer salesModel) {
        this.salesModel = salesModel;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Goods goodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public Goods goodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
        return this;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getSpuNo() {
        return spuNo;
    }

    public Goods spuNo(String spuNo) {
        this.spuNo = spuNo;
        return this;
    }

    public void setSpuNo(String spuNo) {
        this.spuNo = spuNo;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Goods categoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public Goods freight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public Goods goodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
        return this;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public Long getProposer() {
        return proposer;
    }

    public Goods proposer(Long proposer) {
        this.proposer = proposer;
        return this;
    }

    public void setProposer(Long proposer) {
        this.proposer = proposer;
    }

    public Instant getApplicationTime() {
        return applicationTime;
    }

    public Goods applicationTime(Instant applicationTime) {
        this.applicationTime = applicationTime;
        return this;
    }

    public void setApplicationTime(Instant applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public Goods checkStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
        return this;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckFailureReasons() {
        return checkFailureReasons;
    }

    public Goods checkFailureReasons(String checkFailureReasons) {
        this.checkFailureReasons = checkFailureReasons;
        return this;
    }

    public void setCheckFailureReasons(String checkFailureReasons) {
        this.checkFailureReasons = checkFailureReasons;
    }

    public Instant getCheckTime() {
        return checkTime;
    }

    public Goods checkTime(Instant checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public void setCheckTime(Instant checkTime) {
        this.checkTime = checkTime;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public Goods goodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
        return this;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public Goods deleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Boolean isSaleState() {
        return saleState;
    }

    public Goods saleState(Boolean saleState) {
        this.saleState = saleState;
        return this;
    }

    public void setSaleState(Boolean saleState) {
        this.saleState = saleState;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Goods)) {
            return false;
        }
        return id != null && id.equals(((Goods) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Goods{" +
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
