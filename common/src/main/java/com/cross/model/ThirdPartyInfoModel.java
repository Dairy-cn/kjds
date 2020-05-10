package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.ThirdPartyType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * @author hcy
 * @descrption 第三方信息
 * @date 2019-5-30.
 */
@Data
public class ThirdPartyInfoModel implements Serializable {

    private Long id;

    @ApiModelProperty(value = "第三方名称")
    private String name;

    @ApiModelProperty(value = "获取第三方数据地址")
    private String getDataUrl;

    @ApiModelProperty(value = "向第三方推送数据地址")
    private String sendDataUrl;

    @ApiModelProperty(value = "企业id（我们在第三方的企业编号）")
    private String partnerId;

    @ApiModelProperty(value = "第三方类型")
    private ThirdPartyType thirdPartyType;

    @ApiModelProperty(value = "平台id")
    private Long platformId;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addTime;

    @ApiModelProperty(value = "加密秘钥")
    private String secret;

    /** added by wy at 20190726 start*/
    @ApiModelProperty(value = "解密秘钥")
    private String secretKey;
    /** added by wy at 20190726 end*/

    @ApiModelProperty(value = "三方卡号")
    private String cardId;

    @ApiModelProperty(value = "是否需要第三方向顾客发送短信")
    private Boolean isSendMsg;

    @ApiModelProperty(value = "替换内容")
    private List<ReplaceContentVM> replaceContents;
}
