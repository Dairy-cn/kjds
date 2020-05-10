package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.dish.ShopDish;
import com.cross.model.enumeration.ThirdPartyType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the PlatDish entity.
 */
@Data
public class PlatDishDTO implements Serializable {
    
    private Long id;
    
    @NotNull
    private Long platId;
    
    @NotNull
    private Long dishId;
    
    private Boolean isDelete;
    
    private Boolean isShow;
    
    // @NotNull
    private Long categoryId;
    
    private Integer sortIndex;
    
    private Long brandId;
    
    @NotNull
    @ApiModelProperty(value = "门店id")
    private Long merchantId;
    
    private ShopDish shopDish;
    
    @ApiModelProperty(value = "图片路径")
    private String imagePath;
    
    @ApiModelProperty(value = "售卖开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant saleStartTime;
    
    @ApiModelProperty(value = "售卖结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant saleEndTime;
    
    /**
     * 一个菜品可能存在多个标签，通过状态码进行表示。
     * 其中：
     * 1：火爆  2：限时秒杀  4：必吃  8：新品  16：必玩
     */
    @ApiModelProperty(value = "菜品标签")
    private Integer dishTag;
    
    @ApiModelProperty(value = "使用规则")
    private List<String> useRules;
    
    @ApiModelProperty(value = "菜品状态 0：已售罄  1：未开始  2：进行中 3：已结束")
    private Integer dishState;
    
    @ApiModelProperty(value = "门店位置坐标")
    private String position;
    
    @ApiModelProperty(value = "配送范围")
    private List<List<String>> shippingRange;
    
    @ApiModelProperty(value = "产品限时抢购：1限时商品；0不限时")
    private Integer timeLimitType;
    
    @ApiModelProperty(value = "预约方式：1预约制；2免预约；3电话预约")
    private Integer reviewStatus;
    
    @ApiModelProperty(value = "商品需要提前预约（单位：天）")
    private Integer advanceDay;
    
    @ApiModelProperty(value = "是否生鲜：1是；0不是（生鲜产品下单时需填写：发货日期，收货地址）")
    private Integer fresh;
    
    @ApiModelProperty(value = "下单时必填的附加信息：0没有; 1身份证号; 2预约时间, 3身份证号/预约时间")
    private Integer mustFill;
    
    @ApiModelProperty(value = "是否开启使用规则")
    private Boolean openUseRule;
    
    @ApiModelProperty(value = "是否开启温馨提示")
    private Boolean openPrompt;
    
    @ApiModelProperty(value = "温馨提示")
    private String prompt;
    
    @ApiModelProperty(value = "商品详情")
    private String content;
    
    @ApiModelProperty(value = "商品标签（多个使用,分隔）")
    private String tagStr;
    
    
    @ApiModelProperty(value = "身份证号码 1=下单必填身份证")
    private Integer requireIdcard;
    
    
    @ApiModelProperty(value = "1=下单必填收货地址")
    private Integer requireAddress;
    
    
    @ApiModelProperty(value = "1=支持同城自提")
    private Integer requireMention;
    
    @ApiModelProperty(value = "1=下单必填指定日期")
    private Integer requireDay;
    
    
    @ApiModelProperty(value = "充值账号类型,Phone:手机号； QQ:腾讯QQ； WeChat:微信号")
    private String requireRecharge;
    
    @ApiModelProperty(value = "针对实名票，买1份，填写客人的信息，如：[“name”,”mobile”,”idcard”]")
    private String repeatFields;
    
    
    @ApiModelProperty(value = "实名票买1份需要填多少个人的信息，比如亲子套票，买1张票要填两个大人身份证 2")
    private Integer repeatPeoplenum;
    
    @ApiModelProperty(value = "通吃岛平台id")
    private Long tcdPlatformId;
    
    /**
     * 菜品绑定的门店信息
     */
    @ApiModelProperty(value = "门店位置坐标")
    private List<DishMerchantInfoVM> dishMerchantShippingInfo;
    
    @ApiModelProperty(value = "门店经度")
    private Double lng;
    
    @ApiModelProperty(value = "门店纬度")
    private Double lat;
    
    @ApiModelProperty(value = "置顶时间：用于排序")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    
    private Instant topTime;
    
    @ApiModelProperty(value = "添加时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    
    private Instant addTime;
    
    /**
     * 卡券有效期
     */
    @ApiModelProperty(value = "卡券有效期兑换后 有效天数")
    private Integer productEffectiveDays;
    
    @ApiModelProperty(value = " 1：通吃岛套餐商品（商品类型类null或者乐玩）2：淘券商品：商品类型为淘券")
    private Integer source;
    
    @ApiModelProperty(value = "分类名称")
    private String categoryName;
    
    @ApiModelProperty(value = "商品名称")
    private String dishName;
    /**
     * 第三方类型
     */
    @ApiModelProperty(value = "第三方类型")
    private ThirdPartyType thirdPartyType;
    
    
    public PlatDishDTO() {
    
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        PlatDishDTO platDishDTO = (PlatDishDTO) o;
        if (platDishDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platDishDTO.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "PlatDishDTO{" +
            "id=" + id +
            ", platId=" + platId +
            ", dishId=" + dishId +
            ", isDelete=" + isDelete +
            ", isShow=" + isShow +
            ", categoryId=" + categoryId +
            ", sortIndex=" + sortIndex +
            ", merchantId=" + merchantId +
            ", shopDish=" + shopDish +
            ", imagePath='" + imagePath + '\'' +
            ", saleStartTime=" + saleStartTime +
            ", saleEndTime=" + saleEndTime +
            ", dishTag=" + dishTag +
            ", useRules=" + useRules +
            ", dishState=" + dishState +
            ", position='" + position + '\'' +
            ", shippingRange=" + shippingRange +
            ", timeLimitType=" + timeLimitType +
            ", reviewStatus=" + reviewStatus +
            ", advanceDay=" + advanceDay +
            ", fresh=" + fresh +
            ", mustFill=" + mustFill +
            ", openUseRule=" + openUseRule +
            ", openPrompt=" + openPrompt +
            ", prompt='" + prompt + '\'' +
            ", content='" + content + '\'' +
            ", tagStr='" + tagStr + '\'' +
            ", requireIdcard=" + requireIdcard +
            ", requireAddress=" + requireAddress +
            ", requireMention=" + requireMention +
            ", requireDay=" + requireDay +
            ", requireRecharge='" + requireRecharge + '\'' +
            ", repeatFields='" + repeatFields + '\'' +
            ", repeatPeoplenum=" + repeatPeoplenum +
            '}';
    }
    
}
