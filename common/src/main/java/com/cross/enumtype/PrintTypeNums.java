package com.cross.enumtype;

import lombok.Getter;

/*************************************************************
 * Description:  打印类型枚举
 * Author: Dairy
 * CreateTime: 2019/6/17
 ************************************************************/
@Getter
public enum PrintTypeNums {

    //  后厨  //
    KITCHEN(1, "后厨"),

    //  前台
    FRONTDESK(2, "前台");


    private Integer code;

    private String msg;

    PrintTypeNums() {
    }

    PrintTypeNums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static PrintTypeNums findOne(int code)  {

        for (PrintTypeNums value : PrintTypeNums.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    public static PrintTypeNums findOne(String type) {

        for (PrintTypeNums value : PrintTypeNums.values()) {
            if (value.getMsg().equals(type)) {
                return value;
            }
        }
        return null;

    }
}
