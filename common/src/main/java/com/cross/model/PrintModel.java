package com.cross.model;

import java.io.Serializable;

/**
 * @Author DuYuLiang on 2017/11/10.
 */
public class PrintModel implements Serializable{
    private String content;
    private String printerSn;
    private Short printNum;
    private String orderSn;
    private String callback;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrintModel)) return false;

        PrintModel PrintModel = (PrintModel) o;

        if (getContent() != null ? !getContent().equals(PrintModel.getContent()) : PrintModel.getContent() != null)
            return false;
        if (getPrinterSn() != null ? !getPrinterSn().equals(PrintModel.getPrinterSn()) : PrintModel.getPrinterSn() != null)
            return false;
        if (getPrintNum() != null ? !getPrintNum().equals(PrintModel.getPrintNum()) : PrintModel.getPrintNum() != null)
            return false;
        if (getOrderSn() != null ? !getOrderSn().equals(PrintModel.getOrderSn()) : PrintModel.getOrderSn() != null)
            return false;
        return getCallback() != null ? getCallback().equals(PrintModel.getCallback()) : PrintModel.getCallback() == null;
    }

    @Override
    public int hashCode() {
        int result = getContent() != null ? getContent().hashCode() : 0;
        result = 31 * result + (getPrinterSn() != null ? getPrinterSn().hashCode() : 0);
        result = 31 * result + (getPrintNum() != null ? getPrintNum().hashCode() : 0);
        result = 31 * result + (getOrderSn() != null ? getOrderSn().hashCode() : 0);
        result = 31 * result + (getCallback() != null ? getCallback().hashCode() : 0);
        return result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrinterSn() {
        return printerSn;
    }

    public void setPrinterSn(String printerSn) {
        this.printerSn = printerSn;
    }

    public Short getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Short printNum) {
        this.printNum = printNum;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    @Override
    public String toString() {
        return "PrintModel{" +
            "content='" + content + '\'' +
            ", printerSn='" + printerSn + '\'' +
            ", printNum=" + printNum +
            ", orderSn='" + orderSn + '\'' +
            ", callback='" + callback + '\'' +
            '}';
    }
}
