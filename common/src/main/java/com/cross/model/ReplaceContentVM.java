package com.cross.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReplaceContentVM {
    @ApiModelProperty("匹配内容")
    private String match;

    @ApiModelProperty("替换内容")
    private String replace;
}
