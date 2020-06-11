package com.cross.merchants.repository;

import com.cross.merchants.domain.PayOrder;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
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


    PayOrder findAllByIdAndStatusAndDeleteStatus(Long id, Integer status, Integer deleteSatus);

    PayOrder findFirstByOrderSn(String orderSn);

    @Query(value="SELECT member_id, COUNT(*),SUM(pay_amount) FROM `pay_order` WHERE (`status`=1 OR `status`=2 OR `status`=3) AND member_id IN :userIds GROUP BY member_id", nativeQuery = true)
    List<Object[]> countAndTotalPayAmountByUserIdIn(@Param("userIds") List<Long> userIds);
}
