package com.cross.enumtype;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.Arrays;

@ApiModel("mdm支付状态枚举")
public enum  MdmPayStateEnum {

    WAIT_PAY(0,"待支付"),
    PAYING(1,"支付中"),
    PAYED(2,"已支付"),
    PAY_FAILED(3,"支付失败"),
    REFUND(4,"退款"),
    CLOSED(5,"已关闭"),
    REVOCATION(6,"撤销");

    private Integer code;
    private String msg;

    MdmPayStateEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static MdmPayStateEnum getPayStateByCode(Integer code){
        ArrayList<MdmPayStateEnum> list = new ArrayList(Arrays.asList(MdmPayStateEnum.values()));
        for (MdmPayStateEnum e:list){
            if(e.code.equals(code)){
                return e;
            }
        }

        //返回数据与文档不符，10对应的也是待支付状态
        if(code==10){
            return MdmPayStateEnum.WAIT_PAY;
        }
        return null;
    }
}
