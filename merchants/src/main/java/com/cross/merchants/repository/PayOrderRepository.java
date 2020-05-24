package com.cross.merchants.repository;

import com.cross.merchants.domain.PayOrder;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

/**
 * Spring Data  repository for the PayOrder entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PayOrderRepository extends JpaRepository<PayOrder, Long> {


    List<PayOrder> findAllByStatusAndCreateTimeLessThan(Integer status, Instant time);


    PayOrder findAllByIdAndStatusAndDeleteStatus(Long id,Integer status, Integer deleteSatus);


}
