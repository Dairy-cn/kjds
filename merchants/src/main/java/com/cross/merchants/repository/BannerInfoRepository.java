package com.cross.merchants.repository;

import com.cross.merchants.domain.BannerInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the BannerInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BannerInfoRepository extends JpaRepository<BannerInfo, Long> {


    int countAllByBannerTypeAndStoreId(Integer type, Long storeId);


    int countAllByBannerTypeAndPositionType(Integer type, Integer positionType);

    int countAllByBannerType(Integer type);



    int countAllByBannerTypeAndPositionTypeAndPositionCode(Integer type, Integer positionType, Integer positionCode);


    List<BannerInfo> findAllByBannerTypeAndPositionTypeOrderByTopDescIdDesc(Integer type, Integer positionType);


    List<BannerInfo> findAllByBannerTypeOrderByTopDescIdDesc(Integer bannerType);



    @Query(value="update   banner_info set top =false  where banner_type=2",nativeQuery=true)
    @Modifying
    int updateTopStateFalseByPlatform();


    @Query(value="update   banner_info set top =false  where banner_type=1 and store_id= :storeId",nativeQuery=true)
    @Modifying
    int updateTopStateFalseByStoreId(@Param("storeId") Long storeId);

    @Query(value="update   banner_info set top =true  where id= :id",nativeQuery=true)
    @Modifying
    int updateTopStateById(@Param("id") Long id);


    List<BannerInfo> findAllByBannerTypeAndStoreIdOrderByTopDescIdDesc(Integer type, Long storeId);



}
