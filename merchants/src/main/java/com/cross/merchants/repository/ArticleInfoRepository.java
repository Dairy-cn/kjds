package com.cross.merchants.repository;

import com.cross.merchants.domain.ArticleInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ArticleInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ArticleInfoRepository extends JpaRepository<ArticleInfo, Long>, JpaSpecificationExecutor<ArticleInfo> {


    @Query(value = "UPDATE `article_info` SET top= :top WHERE id= :id", nativeQuery = true)
    @Modifying
    int updateTopStatus(@Param("id") Long id, @Param("top") Boolean top);

    @Query(value = "UPDATE `article_info` SET top= false WHERE top=true", nativeQuery = true)
    @Modifying
    int setTopStatusFalse();


    @Query(value = "UPDATE `article_info` SET show_state= :state WHERE id= :id", nativeQuery = true)
    @Modifying
    int updateShowState(@Param("id") Long id,@Param("state") Boolean state);


}