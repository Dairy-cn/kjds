package com.cross.model;

import com.cross.enumtype.TaoQuanProductType;
import com.cross.model.TaoQuanDataVM.TaoQuanMerchantInfoVm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wy
 * @descrption TODO
 * @date 2019-7-30.
 */
@Data
public class TaoQuanMyProduct{

    @ApiModelProperty("平台编码")
    private Long platFormId;

    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    @ApiModelProperty("产品编号")
    String goodsNo;

    @ApiModelProperty("商品名称")
    private String goodsTypeName;
    /**
     * 产品品牌编号
     */
    @ApiModelProperty(value = "产品品牌编号")
    private Integer goodsTypeId;

    @ApiModelProperty(value = "商品类型 卡券 卡密")
    private TaoQuanProductType productType;

    @ApiModelProperty("商品规格名称")
    private String name;

    @ApiModelProperty("商品售价")
    private Float price;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty("商品所在门店信息")
    private TaoQuanMerchantInfoVm merchant;

    @ApiModelProperty(value = "商品分类id ")
    private Long shopCatId;

    @ApiModelProperty(value = "商品分类名称")
    private String categoryName;

    @ApiModelProperty(value = "第三应用编号")
    private Long thirdPartyId;

    @ApiModelProperty(value = "销量")
    private Integer saleNum;
}

