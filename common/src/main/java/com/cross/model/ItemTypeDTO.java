package com.cross.model;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchant.domain.ItemType} entity.
 */
public class ItemTypeDTO implements Serializable {

    private Long id;

    /**
     * mdm主键
     */
    @ApiModelProperty(value = "mdm主键")
    private String guid;

    /**
     * 我方主键
     */
    @ApiModelProperty(value = "我方主键")
    private String thirdNo;

    /**
     * 门店guid
     */
    @ApiModelProperty(value = "门店guid")
    private String storeGuid;

    /**
     * 品牌guid
     */
    @ApiModelProperty(value = "品牌guid")
    private String brandGuid;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 名称
     */
    @ApiModelProperty(value = "描述")
    @Size(max = 50)
    private String description;
    /**
     * 描述\ndescription String,\n/**分类来源 0门店1 品牌
     */
    @ApiModelProperty(value = "描述\ndescription String,\n/**分类来源 0门店1 品牌")
    private String typeFrom;


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

    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeFrom() {
        return typeFrom;
    }

    public void setTypeFrom(String typeFrom) {
        this.typeFrom = typeFrom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ItemTypeDTO itemTypeDTO = (ItemTypeDTO) o;
        if (itemTypeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), itemTypeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ItemTypeDTO{" +
            "id=" + id +
            ", guid='" + guid + '\'' +
            ", thirdNo='" + thirdNo + '\'' +
            ", storeGuid='" + storeGuid + '\'' +
            ", brandGuid='" + brandGuid + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", typeFrom='" + typeFrom + '\'' +
            '}';
    }
}
