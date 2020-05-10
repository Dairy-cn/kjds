package com.cross.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2019/8/5
 ************************************************************/
public class IslandUserModel implements Serializable {


    private static final long serialVersionUID = 925553778877595228L;

    @JsonProperty("id")
    private Long id;


    /**
     * 用户头像
     */
    @JsonProperty("head_pic")
    private String headPic;

    /**
     * 达人昵称
     */
    @JsonProperty("nick_name")
    private String nickName;


    public IslandUserModel() {
    }

    public IslandUserModel(Long id, String headPic, String nickName) {
        this.id = id;
        this.headPic = headPic;
        this.nickName = nickName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "IslandUserModel{" +
            "id=" + id +
            ", headPic='" + headPic + '\'' +
            ", nickName='" + nickName + '\'' +
            '}';
    }
}
