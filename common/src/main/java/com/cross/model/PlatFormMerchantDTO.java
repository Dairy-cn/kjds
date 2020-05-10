package com.cross.model;


import com.cross.model.dish.ShopDish;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the PlatFormMerchant entity.
 */
public class PlatFormMerchantDTO implements Serializable {

    private Long id;

    @ApiModelProperty(value = "门店编码")
    private Long merchantId;

    private String merchantIds;

    private Integer cooperationStatus;

    private Double brokerage;

    private Boolean show;

    private Long platFormUserId;
    
    
    @ApiModelProperty("入住前的平台Id")
    private Long oldPlatFormUserId;


    private MerchantModel merchantModel;


    private Long platFormShopCategoryId;

    private String login;

    private String accountName;

    private String categoryName;

    private String categoryNameChild;

    private Integer showStatus;

    @ApiModelProperty("订单类型 1:堂食  2：外卖  4：物流 8优惠买单 16扫码点餐")
    private String outerOrderMod;

    private Integer status;

    private String merchantName;

    private Long accountId;

    private Long teamId;

    private Long parentId;

    private Long childId;
    /**
     * 是否删除
     */
    private Boolean isDelete = false;

    @ApiModelProperty(value = "绑定门店管理员用户id")
    private Long managerUserId;

    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    @ApiModelProperty(value = "门店id")
    private Long merchant;


    @ApiModelProperty(value = "店铺状态 0休息 1营业 2打烊 3忙碌")
    private Integer merchantStatus;


    @ApiModelProperty(value = "店铺Logo")
    private String merchantLogo;

    @ApiModelProperty(value = "品牌")
    private String brandName;



    @ApiModelProperty(value = "是否开启配送")
    private Boolean openShipping = Boolean.FALSE;


    @ApiModelProperty(value = "快递公司列表")
    private List<ShippingListModel> shippingListModels;

    @ApiModelProperty(value = "满减活动信息")
    private ShopFullReductionActivityDTO shopFullReductionActivityDTO;


    @ApiModelProperty(value = "门店分类id")
    private List<Long> catId;

    @ApiModelProperty(value = "门店分类名称")
    private List<String> catName;
    
    @ApiModelProperty(value = "是否开启自提")
    private Boolean pickUpSelf;
    
    @ApiModelProperty(value = "门店环境图")
    private String merchantAroundPic;
    
    @ApiModelProperty(value = "门店宣传图")
    private String merchantPropagandaPic;
    
    @ApiModelProperty(value = "门店商品", hidden = true)
    private List<ShopDish> shopDishList;
    
    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String picUrl;
    
    /**
     * 图片展示 1 菜品 2 门店
     */
    @ApiModelProperty(value = "图片展示 1 菜品 2 门店 ")
    private Integer picShowType;
    
    
    
    @ApiModelProperty(value = "门店外卖宣传图")
    private String merchantNetworkPropagandaPic;
    
    
    @ApiModelProperty(value = "门店扫码点餐宣传图")
    private String merchantScanCodePropagandaPic;
    
    @ApiModelProperty(value = "门店优惠买单宣传图")
    private String merchantOfferToPayPropagandaPic;

    @ApiModelProperty(value = "配送类型 0：关闭 1：美团配送 2：自配送 4：蜂鸟配送")
    private Integer sendType;
    
    public String getMerchantNetworkPropagandaPic() {
        return merchantNetworkPropagandaPic;
    }
    
    public void setMerchantNetworkPropagandaPic(String merchantNetworkPropagandaPic) {
        this.merchantNetworkPropagandaPic = merchantNetworkPropagandaPic;
    }
    
    public String getMerchantScanCodePropagandaPic() {
        return merchantScanCodePropagandaPic;
    }
    
    public void setMerchantScanCodePropagandaPic(String merchantScanCodePropagandaPic) {
        this.merchantScanCodePropagandaPic = merchantScanCodePropagandaPic;
    }
    
    public String getMerchantOfferToPayPropagandaPic() {
        return merchantOfferToPayPropagandaPic;
    }
    
    public void setMerchantOfferToPayPropagandaPic(String merchantOfferToPayPropagandaPic) {
        this.merchantOfferToPayPropagandaPic = merchantOfferToPayPropagandaPic;
    }
    
    public String getPicUrl() {
        return picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    
    public List<ShopDish> getShopDishList() {
        return shopDishList;
    }
    
    public void setShopDishList(List<ShopDish> shopDishList) {
        this.shopDishList = shopDishList;
    }
    
    public List<ShippingListModel> getShippingListModels() {
        return shippingListModels;
    }

    public void setShippingListModels(List<ShippingListModel> shippingListModels) {
        this.shippingListModels = shippingListModels;
    }

    public ShopFullReductionActivityDTO getShopFullReductionActivityDTO() {
        return shopFullReductionActivityDTO;
    }

    public void setShopFullReductionActivityDTO(ShopFullReductionActivityDTO shopFullReductionActivityDTO) {
        this.shopFullReductionActivityDTO = shopFullReductionActivityDTO;
    }

    public MerchantModel getMerchantModel() {
        return merchantModel;
    }

    public void setMerchantModel(MerchantModel merchantModel) {
        this.merchantModel = merchantModel;
    }

    public Integer getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(Integer merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public Long getMerchant() {
        return merchant;
    }

    public void setMerchant(Long merchant) {
        this.merchant = merchant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getCooperationStatus() {
        return cooperationStatus;
    }

    public void setCooperationStatus(Integer cooperationStatus) {
        this.cooperationStatus = cooperationStatus;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    public Boolean isShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Long getPlatFormUserId() {
        return platFormUserId;
    }

    public void setPlatFormUserId(Long platFormUserId) {
        this.platFormUserId = platFormUserId;
    }

    public String getMerchantIds() {
        return merchantIds;
    }

    public void setMerchantIds(String merchantIds) {
        this.merchantIds = merchantIds;
    }


    public Boolean getShow() {
        return show;
    }

    public Long getPlatFormShopCategoryId() {
        return platFormShopCategoryId;
    }

    public void setPlatFormShopCategoryId(Long platFormShopCategoryId) {
        this.platFormShopCategoryId = platFormShopCategoryId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryNameChild() {
        return categoryNameChild;
    }

    public void setCategoryNameChild(String categoryNameChild) {
        this.categoryNameChild = categoryNameChild;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getOuterOrderMod() {
        return outerOrderMod;
    }

    public void setOuterOrderMod(String outerOrderMod) {
        this.outerOrderMod = outerOrderMod;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Long getManagerUserId() {
        return managerUserId;
    }

    public void setManagerUserId(Long managerUserId) {
        this.managerUserId = managerUserId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getMerchantLogo() {
        return merchantLogo;
    }

    public void setMerchantLogo(String merchantLogo) {
        this.merchantLogo = merchantLogo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Boolean getOpenShipping() {
        return openShipping;
    }

    public void setOpenShipping(Boolean openShipping) {
        this.openShipping = openShipping;
    }

    public List<Long> getCatId() {
        return catId;
    }

    public void setCatId(List<Long> catId) {
        this.catId = catId;
    }

    public List<String> getCatName() {
        return catName;
    }

    public void setCatName(List<String> catName) {
        this.catName = catName;
    }
    
    public Long getOldPlatFormUserId() {
        return oldPlatFormUserId;
    }
    
    public void setOldPlatFormUserId(Long oldPlatFormUserId) {
        this.oldPlatFormUserId = oldPlatFormUserId;
    }
    
    public Boolean getPickUpSelf() {
        return pickUpSelf;
    }
    
    public void setPickUpSelf(Boolean pickUpSelf) {
        this.pickUpSelf = pickUpSelf;
    }
    
    public String getMerchantAroundPic() {
        return merchantAroundPic;
    }
    
    public void setMerchantAroundPic(String merchantAroundPic) {
        this.merchantAroundPic = merchantAroundPic;
    }
    
    public String getMerchantPropagandaPic() {
        return merchantPropagandaPic;
    }
    
    public void setMerchantPropagandaPic(String merchantPropagandaPic) {
        this.merchantPropagandaPic = merchantPropagandaPic;
    }
    
    public Integer getPicShowType() {
        return picShowType;
    }
    
    public void setPicShowType(Integer picShowType) {
        this.picShowType = picShowType;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlatFormMerchantDTO platFormMerchantDTO = (PlatFormMerchantDTO) o;
        if(platFormMerchantDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platFormMerchantDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "PlatFormMerchantDTO{" +
            "id=" + id +
            ", merchantId=" + merchantId +
            ", merchantIds='" + merchantIds + '\'' +
            ", cooperationStatus=" + cooperationStatus +
            ", brokerage=" + brokerage +
            ", show=" + show +
            ", platFormUserId=" + platFormUserId +
            ", oldPlatFormUserId=" + oldPlatFormUserId +
            ", merchantModel=" + merchantModel +
            ", platFormShopCategoryId=" + platFormShopCategoryId +
            ", login='" + login + '\'' +
            ", accountName='" + accountName + '\'' +
            ", categoryName='" + categoryName + '\'' +
            ", categoryNameChild='" + categoryNameChild + '\'' +
            ", showStatus=" + showStatus +
            ", outerOrderMod='" + outerOrderMod + '\'' +
            ", status=" + status +
            ", merchantName='" + merchantName + '\'' +
            ", accountId=" + accountId +
            ", teamId=" + teamId +
            ", parentId=" + parentId +
            ", childId=" + childId +
            ", isDelete=" + isDelete +
            ", managerUserId=" + managerUserId +
            ", brandId=" + brandId +
            ", merchant=" + merchant +
            ", merchantStatus=" + merchantStatus +
            ", merchantLogo='" + merchantLogo + '\'' +
            ", brandName='" + brandName + '\'' +
            ", openShipping=" + openShipping +
            ", shippingListModels=" + shippingListModels +
            ", shopFullReductionActivityDTO=" + shopFullReductionActivityDTO +
            ", catId=" + catId +
            ", catName=" + catName +
            ", pickUpSelf=" + pickUpSelf +
            ", merchantAroundPic='" + merchantAroundPic + '\'' +
            ", merchantPropagandaPic='" + merchantPropagandaPic + '\'' +
            ", shopDishList=" + shopDishList +
            ", picUrl='" + picUrl + '\'' +
            ", picShowType=" + picShowType +
            '}';
    }
}
