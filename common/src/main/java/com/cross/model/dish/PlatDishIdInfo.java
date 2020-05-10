package com.cross.model.dish;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author hcy
 * @descrption TODO
 * @date 2019-9-20.
 */
public class PlatDishIdInfo implements Serializable {
    
    private Long dishId;
    
    private Long platformId;
    
    private Boolean isShow;
    
    @ApiModelProperty(value = "置顶时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant topTime;
    
    
    public Instant getTopTime() {
        return topTime;
    }
    
    public void setTopTime(Instant topTime) {
        this.topTime = topTime;
    }
    
    public Long getDishId() {
        return dishId;
    }
    
    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    
    public Boolean getShow() {
        return isShow;
    }
    
    public void setShow(Boolean show) {
        isShow = show;
    }
}
