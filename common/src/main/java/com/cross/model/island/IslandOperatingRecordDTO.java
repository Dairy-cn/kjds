package com.cross.model.island;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * A DTO for the IslandOperatingRecord entity.
 */
@ApiModel(description = "操作记录表")
public class IslandOperatingRecordDTO implements Serializable {
    
    /**
     * 操作ID
     */
    private Long id;
    
    
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private String operateTime;
    
    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id")
    private Long platformId;
    
    /**
     * 操作者ID
     */
    @ApiModelProperty(value = "操作者ID")
    private Long operatorId;
    
    /**
     * 操作员
     */
    @ApiModelProperty(value = "操作员")
    private String operatorName;
    
    /**
     * 操作名称
     */
    @ApiModelProperty(value = "操作名称")
    private String operateName;
    
    /**
     * 操作结果 0-成功 1-失败
     */
    @ApiModelProperty(value = "操作结果 0-成功 1-失败")
    private Integer result;
    
    /**
     * 操作详情
     */
    @ApiModelProperty(value = "操作详情")
    private String detail;
    
    
    /**
     * 删除
     */
    @ApiModelProperty(value = "删除")
    private Boolean isDelete;
    
    /**
     * 日志类型
     */
    @ApiModelProperty(value = "type")
    private String type;
    /**
     * 日志标题
     */
    @ApiModelProperty(value = "title")
    private String title;
    /**
     * 请求地址
     */
    @ApiModelProperty(value = "remoteAddr")
    private String remoteAddr;
    /**
     * URI
     */
    @ApiModelProperty(value = "requestUri")
    private String requestUri;
    /**
     * 请求方式
     */
    @ApiModelProperty(value = "method")
    private String method;
    /**
     * 提交参数
     */
    @ApiModelProperty(value = "params")
    private String params;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "exception")
    private String exception;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "timeout")
    private String timeout;
    
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getRemoteAddr() {
        return remoteAddr;
    }
    
    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }
    
    public String getRequestUri() {
        return requestUri;
    }
    
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }
    
    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public String getParams() {
        return params;
    }
    
    public void setParams(String params) {
        this.params = params;
    }
    
    public String getException() {
        return exception;
    }
    
    public void setException(String exception) {
        this.exception = exception;
    }
    
    public String getTimeout() {
        return timeout;
    }
    
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
    
    public Boolean getDelete() {
        return isDelete;
    }
    
    public void setDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public String getOperateTime() {
        return operateTime;
    }
    
    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    
    public Long getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
    
    public String getOperatorName() {
        return operatorName;
    }
    
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    
    public String getOperateName() {
        return operateName;
    }
    
    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }
    
    public Integer getResult() {
        return result;
    }
    
    public void setResult(Integer result) {
        this.result = result;
    }
    
    public String getDetail() {
        return detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    @Override
    public String toString() {
        return "IslandOperatingRecordDTO{" +
            "id=" + id +
            ", operateTime='" + operateTime + '\'' +
            ", platformId=" + platformId +
            ", operatorId=" + operatorId +
            ", operatorName=" + operatorName +
            ", operateName='" + operateName + '\'' +
            ", result=" + result +
            ", detail='" + detail + '\'' +
            '}';
    }
    
    /**
     * 设置请求参数
     * @param paramMap
     */
    public void setMapToParams(Map<String, String[]> paramMap) {
        if (paramMap == null){
            return;
        }
        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String[]> param : ((Map<String, String[]>)paramMap).entrySet()){
            params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
            String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
            params.append(paramValue);
        }
        this.params = params.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        IslandOperatingRecordDTO islandOperatingRecordDTO = (IslandOperatingRecordDTO) o;
        if (islandOperatingRecordDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandOperatingRecordDTO.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    public IslandOperatingRecordDTO() {
    }
    
    
}
