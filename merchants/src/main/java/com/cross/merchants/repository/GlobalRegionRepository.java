package com.cross.merchants.repository;

import com.cross.merchants.domain.GlobalRegion;

import com.cross.merchants.domain.Region;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the GlobalRegion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GlobalRegionRepository extends JpaRepository<GlobalRegion, Long> {

    List<GlobalRegion> getAllByPid(Long parentId);

    List<GlobalRegion> getAllByLevel(Integer level);

    List<GlobalRegion> findAllByIdIn(List<Long> ids);


}
