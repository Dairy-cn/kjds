package com.cross.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/*************************************************************
 * Description: 
 * Author: Dair
 * CreateTime: 2020/5/10
 ************************************************************/
@ApiModel(description = "接口返回数据")
public class R implements Serializable {
	
	@ApiModelProperty("请求结果")
	private boolean flag;
	@ApiModelProperty("请求结果code")
	private Integer code;
	
	@ApiModelProperty("请求message")
	private String message;
	
	@ApiModelProperty("请求返回数据")
	private Object data;
	
	@ApiModelProperty("分页查询的总条数")
	private Long count;
	
	private R() {
	}
	
	private R(boolean flag, Integer code, String message) {
		super();
		this.flag = flag;
		this.code = code;
		this.message = message;
	}
	
	private R(boolean flag, Integer code, String message, Object data) {
		super();
		this.flag = flag;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	private R(boolean flag, Integer code, String message, Object data, Long count) {
		super();
		this.flag = flag;
		this.code = code;
		this.message = message;
		this.data = data;
		this.count = count;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	/**
	 * 返回成功消息
	 * @return Result
	 */
	public static R ok() {
		return new R(true, StatusCode.OK, "ok");
	}
	
	/**
	 * 返回成功消息
	 * @return Result
	 */
	public static R ok(Object data) {
		return new R(true, StatusCode.OK, "ok", data);
	}
	
	/**
	 * 返回成功消息
	 * @return Result
	 */
	public static R ok(String message, Object data) {
		return new R(true, StatusCode.OK, "ok", data);
	}
	
	/**
	 * 返回成功消息
	 * @return Result
	 */
	public static R ok(Object data, Long count) {
		return new R(true, StatusCode.OK, "ok", data, count);
	}
	
	/**
	 * 返回失败消息
	 * @return Result
	 */
	public static R error() {
		return new R(false, StatusCode.ERROR, "fail");
	}
	
	/**
	 * 返回失败消息
	 * @return Result
	 */
	public static R error(String message) {
		return new R(false, StatusCode.ERROR, message);
	}
	
	/**
	 * 返回失败消息
	 * @return Result
	 */
	public static R errorData( ) {
		return new R(false, StatusCode.ERROR, "数据不存在");
	}
	
	/**
	 * 返回失败消息
	 * @return Result
	 */
	public static R error(Integer code, String message) {
		return new R(false, code, message);
	}
	
	/**
	 * 返回登录失败的消息：用户名或密码错误
	 * @return Result
	 */
	public static R loginError() {
		return new R(false, StatusCode.LOGINERROR, "用户名或密码错误");
	}
	
	/**
	 * 返回权限不足
	 * @return Result
	 */
	public static R accessError() {
		return new R(false, StatusCode.ACCESSERROR, "权限不足");
	}
	
	/**
	 * 返回远程调用失败
	 * @return Result
	 */
	public static R remoteError() {
		return new R(false, StatusCode.REMOTEERROR, "远程调用失败");
	}
	
	/**
	 * 返回重复操作
	 * @return Result
	 */
	public static R repError() {
		return new R(false, StatusCode.REPERROR, "重复操作");
	}

}
