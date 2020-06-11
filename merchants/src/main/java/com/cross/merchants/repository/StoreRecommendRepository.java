package com.cross.merchants.repository;

import com.cross.merchants.domain.StoreRecommend;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the StoreRecommend entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StoreRecommendRepository extends JpaRepository<StoreRecommend, Long> {


    List<StoreRecommend> findAllByOrderByTopDescIdDesc();


    @Query(value = "update   store_recommend set top =false where top=true", nativeQuery = true)
    @Modifying
    int updateTopStateFalse();


    @Query(value = "update   store_recommend set top =true  where id = :id", nativeQuery = true)
    @Modifying
    int updateTopStateTrueById(@Param("id") Long id);


    int countAllByStoreId(Long storeId);


}
