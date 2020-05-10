package com.cross.model;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangjuzheng
 * @since 2019-05-08
 */
@Data
public class PlatformMemberPageDTO implements Serializable {

    private List<PlatformMemberInfoDTO> list;
    private Long totalCount;

    public PlatformMemberPageDTO() {
    }

    public PlatformMemberPageDTO(List<PlatformMemberInfoDTO> list, Long totalCount) {
        this.list = list;
        this.totalCount = totalCount;
    }
}
