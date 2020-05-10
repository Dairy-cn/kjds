package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * 平台会员信息查询条件DTO
 *
 * @author wangjuzheng
 * @since 2019-05-07
 */
public class PlatformMemberQueryDTO implements Serializable {

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id")
    private Long platformId;

    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phone;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "页码")
    private Integer currentPage;

    /**
     * 每页显示条数
     */
    @ApiModelProperty(value = "每页显示条数")
    private Integer pageSize;

    public PlatformMemberQueryDTO() {
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatformMemberQueryDTO that = (PlatformMemberQueryDTO) o;
        return Objects.equals(platformId, that.platformId) &&
            Objects.equals(phone, that.phone) &&
            Objects.equals(currentPage, that.currentPage) &&
            Objects.equals(pageSize, that.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platformId, phone, currentPage, pageSize);
    }

    @Override
    public String toString() {
        return "PlatformMemberQueryDTO{" +
            "platformId=" + platformId +
            ", phone='" + phone + '\'' +
            ", currentPage=" + currentPage +
            ", pageSize=" + pageSize +
            '}';
    }
}
