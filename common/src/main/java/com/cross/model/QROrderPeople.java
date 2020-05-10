package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 马晓林
 * @since 2019/9/26 15:56
 * 点餐人详情
 */
public class QROrderPeople  implements Serializable {

    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String headImageUrl;
    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickName;

    /**
     * 用户唯一id
     */
    @ApiModelProperty("用户唯一id")
    private Long id;
    /**
     * 点餐状态 1点餐中  0结束点餐
     */
    @ApiModelProperty("点餐状态 1点餐中  0结束点餐")
    private Integer status;

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QROrderPeople{" +
            "headImageUrl='" + headImageUrl + '\'' +
            ", nickName='" + nickName + '\'' +
            ", Id='" + id + '\'' +
            ", status=" + status +
            '}';
    }
}
