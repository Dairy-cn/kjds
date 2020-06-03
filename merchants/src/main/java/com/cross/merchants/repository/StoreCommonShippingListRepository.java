package com.cross.merchants.repository;

import com.cross.merchants.domain.StoreCommonShippingList;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the StoreCommonShippingList entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StoreCommonShippingListRepository extends JpaRepository<StoreCommonShippingList, Long> {

    List<StoreCommonShippingList> findAllByStoreId(Long storeId);


    StoreCommonShippingList findFirstByStoreIdAndShippingId(Long storeId,Long shippingId);
}
