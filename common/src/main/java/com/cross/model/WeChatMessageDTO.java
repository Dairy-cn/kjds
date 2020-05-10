package com.cross.model;

import com.cross.model.enumeration.WeChatMessageState;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the WeChatMessage entity.
 */
public class WeChatMessageDTO implements Serializable {

    private Long id;

    private String toUser;

    private String templateId;

    private String url;

    private String topColor;

    private WeChatMessageDataVM data;

    private WeChatMessageState state;

    @Size(max = 2000)
    private String resultMessage;

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id")
    private Long platformId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    public WeChatMessageDataVM getData() {
        return data;
    }

    public void setData(WeChatMessageDataVM data) {
        this.data = data;
    }

    public WeChatMessageState getState() {
        return state;
    }

    public void setState(WeChatMessageState state) {
        this.state = state;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WeChatMessageDTO weChatMessageDTO = (WeChatMessageDTO) o;
        if(weChatMessageDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), weChatMessageDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WeChatMessageDTO{" +
            "id=" + id +
            ", toUser='" + toUser + '\'' +
            ", templateId='" + templateId + '\'' +
            ", url='" + url + '\'' +
            ", topColor='" + topColor + '\'' +
            ", data=" + data +
            ", state=" + state +
            ", resultMessage='" + resultMessage + '\'' +
            ", platformId=" + platformId +
            '}';
    }
}
