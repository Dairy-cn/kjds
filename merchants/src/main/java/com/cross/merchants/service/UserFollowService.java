package com.cross.merchants.service;

import com.cross.merchants.service.dto.BrandDTO;
import com.cross.merchants.service.dto.GoodsDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/26
 ************************************************************/
public interface UserFollowService {


    int addBrandFollow(Long userId, Long brandId);

    int deleteBrandFollow(Long userId, Long brandId);


    List<BrandDTO> getList(Long userId, Pageable pageable);

    long countByUserId(Long userId);

    boolean isFollowBrand(Long userId, Long brandId);

}
