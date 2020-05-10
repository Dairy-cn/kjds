package com.cross.model.TaoQuanDataVM;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @descrption 淘券商家信息
 * @date 2019-5-28.
 */
@Data
public class TaoQuanMerchantInfoVm {

    @ApiModelProperty("商家ID")
    private Long merchantId;

    @ApiModelProperty("商家名")
    private String merchantName;

    @ApiModelProperty("门店编码")
    private Long merchantNo;
}
