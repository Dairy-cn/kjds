package com.cross.merchants.repository;

import com.cross.merchants.domain.ShippingList;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the ShippingList entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ShippingListRepository extends JpaRepository<ShippingList, Long> {

    List<ShippingList> findAllByIdIn(List<Long> ids);
}
