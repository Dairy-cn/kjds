package com.cross.merchants.repository;

import com.cross.merchants.domain.UserAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the UserAddress entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    Page<UserAddress> findAllByUserIdAndDeleteFlagNotOrderByDefaultFlagDescIdDesc(Pageable pageable, Long userId, Boolean delete);

    @Query(value="update   user_address set default_flag =false  where user_id= :userId",nativeQuery=true)
    @Modifying
    int setDefaultFlagById(@Param("userId") Long userId);


    @Query(value="update   user_address set default_flag =true  where  id= :id",nativeQuery=true)
    @Modifying
    int updateDefaultState(@Param("id") Long id);


    List<UserAddress> findAllByUserIdAndDeleteFlagNotOrderByDefaultFlagDescIdDesc(Long userId, Boolean delete);


}
