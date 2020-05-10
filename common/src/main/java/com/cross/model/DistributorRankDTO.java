package com.cross.model;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * 分销等级设置
 */
public class DistributorRankDTO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 供应商用商用户编号
     */
    private Long supplierId;

    /**
     * 品牌标识
     */
    private Long brandId;

    /**
     * 平台标识
     */
    private Long platFormId;

    /**
     * 等级名称
     */
    private String rankName;

    /**
     * 等级ico
     */
    private String rankIco;

    /**
     * 等级折扣
     */
    private Double rankDiscount;

    /**
     * 等级收益
     */
    private Double rankProfit;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 成为该等级需要销售金额
     */
    private Double minSaleAmount;

    /**
     * 其他条件成为该等级
     */
    @Size(max = 2000)
    private String otherCondition;

    /**
     * 权益介绍
     */
    @Size(max = 500)
    private String profitBrief;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(Long platFormId) {
        this.platFormId = platFormId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getRankIco() {
        return rankIco;
    }

    public void setRankIco(String rankIco) {
        this.rankIco = rankIco;
    }

    public Double getRankDiscount() {
        return rankDiscount;
    }

    public void setRankDiscount(Double rankDiscount) {
        this.rankDiscount = rankDiscount;
    }

    public Double getRankProfit() {
        return rankProfit;
    }

    public void setRankProfit(Double rankProfit) {
        this.rankProfit = rankProfit;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Double getMinSaleAmount() {
        return minSaleAmount;
    }

    public void setMinSaleAmount(Double minSaleAmount) {
        this.minSaleAmount = minSaleAmount;
    }

    public String getOtherCondition() {
        return otherCondition;
    }

    public void setOtherCondition(String otherCondition) {
        this.otherCondition = otherCondition;
    }

    public String getProfitBrief() {
        return profitBrief;
    }

    public void setProfitBrief(String profitBrief) {
        this.profitBrief = profitBrief;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DistributorRankDTO distributorRankDTO = (DistributorRankDTO) o;
        if (distributorRankDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), distributorRankDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DistributorRankDTO{" +
            "id=" + id +
            ", supplierId=" + supplierId +
            ", brandId=" + brandId +
            ", platFormId=" + platFormId +
            ", rankName='" + rankName + '\'' +
            ", rankIco='" + rankIco + '\'' +
            ", rankDiscount=" + rankDiscount +
            ", rankProfit=" + rankProfit +
            ", isDelete=" + isDelete +
            ", minSaleAmount=" + minSaleAmount +
            ", otherCondition='" + otherCondition + '\'' +
            ", profitBrief='" + profitBrief + '\'' +
            '}';
    }
}
