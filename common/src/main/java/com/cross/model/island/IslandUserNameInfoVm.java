package com.cross.model.island;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author hcy
 * @descrption TODO
 * @date 2019-9-6.
 */
public class IslandUserNameInfoVm {

    /**
     * 昵称
     */
    private String nickName;

    @ApiModelProperty(value = "微信登电话")
    private String weappLogin;
    
    @ApiModelProperty(value = "头像")
    private String headPic;

    public IslandUserNameInfoVm() {
    }

    public IslandUserNameInfoVm(String nickName, String weappLogin) {
        this.nickName = nickName;
        this.weappLogin = weappLogin;
    }
    
    public IslandUserNameInfoVm(String nickName, String weappLogin, String headPic) {
        this.nickName = nickName;
        this.weappLogin = weappLogin;
        this.headPic = headPic;
    }
    
    public String getHeadPic() {
        return headPic;
    }
    
    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
    
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWeappLogin() {
        return weappLogin;
    }

    public void setWeappLogin(String weappLogin) {
        this.weappLogin = weappLogin;
    }
}
