package com.cross.enumtype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 蜂鸟平台配送状态枚举
 */
public enum  EleShippingStateEnum {
    RECEIVED_ORDER(1,"系统已接单"),
    ALLOCATED(20,"已分配骑手"),
    ARRIVED_MERCHANT(80,"骑手已到店"),
    SENDING(2,"配送中"),
    SENDED(3,"已送达"),
    ABNORMAL(5,"异常"),
    CANCELED(4,"已取消");

    private String msg;
    private Integer code;

    EleShippingStateEnum(Integer code,String msg) {
        this.msg = msg;
        this.code = code;
    }

    public static EleShippingStateEnum getEnumByCode(Integer code){
        EleShippingStateEnum[] values = EleShippingStateEnum.values();
        List<EleShippingStateEnum> list = new ArrayList<>(Arrays.asList(values));
        for(EleShippingStateEnum e:list){
            if(e.getCode().equals(code)){
                return e;
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
