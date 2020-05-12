package com.cross.merchants.handler;

/**
 * 全局异常
 * 全局捕获的父类异常
 * 其他自定义异常应该继承这个异常
 *
 * @author yk
 * @since 2019/4/22$ 18:01$
 */
public class GlobalException extends RuntimeException {

    /**
     * 异常码
     */
    private int returnCode;

    /**
     * 异常内容
     */
    private String returnMessage;

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(int returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
