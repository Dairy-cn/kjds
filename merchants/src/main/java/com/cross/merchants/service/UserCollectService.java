package com.cross.merchants.service;

import com.cross.merchants.service.dto.GoodsDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/26
 ************************************************************/
public interface UserCollectService {


    int addCollect(Long userId, Long goodsId);

    int deleteCollect(Long userId, Long goodsId);


    List<GoodsDTO> getList(Long userId, Pageable pageable);

    long countByUserId(Long userId);

    boolean isCollectGoods(Long userId, Long goodsId);

}
