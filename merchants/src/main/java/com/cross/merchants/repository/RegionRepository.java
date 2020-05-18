package com.cross.merchants.repository;

import com.cross.merchants.domain.Region;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Region entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {


    List<Region> getAllByParentId(Long parentId);

    List<Region> getAllByLevel(Integer level);

}
