package com.cross.model;

import java.io.Serializable;

/**
 * A DTO for the {@link com.cross.merchant.domain.MdmItem} entity.
 */
public class MdmItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 平台主键
     */
    private String  guid;
    /**
     * 第三方唯一标识 我方数据库唯一id
     */
    private Long thirdNo;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 拼音简码
     */
    private String pinyin;

    /**
     * 门店标识（门店和品牌标识不能同时为空）
     */
    private String  storeGuid;

    /**
     * 品牌标识（门店和品牌标识不能同时为空）
     */
    private String brandGuid;

    /**
     * 商品分类
     */
    private String typeGuid;

    /**
     * 商品图片 图片路径数组
     */
    private String pictureUrl;

    /**
     * 商品类型：1.套餐（不称重，无规格），2多规格商品（多商品，不称重），3.称重商品（单商品，称重），4.单品。
     */
    private Integer itemType;
    /**
     * 商品来源（0：门店，1：品牌）
     */
    private Integer itemFrom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Long getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(Long thirdNo) {
        this.thirdNo = thirdNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getStoreGuid() {
        return storeGuid;
    }

    public void setStoreGuid(String storeGuid) {
        this.storeGuid = storeGuid;
    }

    public String getBrandGuid() {
        return brandGuid;
    }

    public void setBrandGuid(String brandGuid) {
        this.brandGuid = brandGuid;
    }

    public String getTypeGuid() {
        return typeGuid;
    }

    public void setTypeGuid(String typeGuid) {
        this.typeGuid = typeGuid;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getItemFrom() {
        return itemFrom;
    }

    public void setItemFrom(Integer itemFrom) {
        this.itemFrom = itemFrom;
    }

    @Override
    public String toString() {
        return "MdmItem{" +
            "id=" + id +
            ", guid='" + guid + '\'' +
            ", thirdNo=" + thirdNo +
            ", name='" + name + '\'' +
            ", pinyin='" + pinyin + '\'' +
            ", storeGuid=" + storeGuid +
            ", brandGuid=" + brandGuid +
            ", typeGuid='" + typeGuid + '\'' +
            ", pictureUrl='" + pictureUrl + '\'' +
            ", itemType=" + itemType +
            ", itemFrom=" + itemFrom +
            '}';
    }

}
