package com.cross.result;

/*************************************************************
 * Description: 打印机返回结果
 * Author: Dairy
 * CreateTime: 2019/6/17
 ************************************************************/
public class PrinterResult {

    private String msg;

    private Integer ret;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    @Override
    public String toString() {
        return "PrinterPrintResult{" +
            "msg='" + msg + '\'' +
            ", ret='" + ret + '\'' +
            '}';
    }
}
