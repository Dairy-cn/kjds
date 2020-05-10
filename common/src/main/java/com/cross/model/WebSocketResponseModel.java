package com.cross.model;

import com.cross.enumtype.SysWebSocketResponseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2019/10/10
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/

@ApiModel(value = "系统websocket返回类")
public class WebSocketResponseModel {
    
    
    @ApiModelProperty("BUY_GOODS 购买商品 DISTRIBUTOR分销商品 PROMOTION 推广  USER_WITHDRAW 用户提现")
    private SysWebSocketResponseType sysWebSocketResponseType;
    
    @ApiModelProperty("用户头像")
    private String headPic;
    
    @ApiModelProperty("用户")
    private String userName;
    
    @ApiModelProperty("金额")
    private BigDecimal amount;
    
    
    @ApiModelProperty("额外消息")
    private String message;
    
    public SysWebSocketResponseType getSysWebSocketResponseType() {
        return sysWebSocketResponseType;
    }
    
    public void setSysWebSocketResponseType(SysWebSocketResponseType sysWebSocketResponseType) {
        this.sysWebSocketResponseType = sysWebSocketResponseType;
    }
    
    public String getHeadPic() {
        return headPic;
    }
    
    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
    
        WebSocketResponseModel that = (WebSocketResponseModel) o;
        
        if (sysWebSocketResponseType != that.sysWebSocketResponseType) return false;
        if (headPic != null ? !headPic.equals(that.headPic) : that.headPic != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
        
    }
    
    @Override
    public int hashCode() {
        int result = sysWebSocketResponseType != null ? sysWebSocketResponseType.hashCode() : 0;
        result = 31 * result + (headPic != null ? headPic.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "WebSocketResponse{" +
            "sysWebSocketResponseType=" + sysWebSocketResponseType +
            ", headPic='" + headPic + '\'' +
            ", userName='" + userName + '\'' +
            ", amount=" + amount +
            ", message='" + message + '\'' +
            '}';
    }
    
}
