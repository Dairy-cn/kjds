package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.ArticleInfoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ArticleInfo} and its DTO {@link ArticleInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ArticleInfoMapper extends EntityMapper<ArticleInfoDTO, ArticleInfo> {



    default ArticleInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(id);
        return articleInfo;
    }
}
