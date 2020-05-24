package com.cross.uaa.repository;

import com.cross.uaa.domain.UserAddress;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserAddress entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    Page<UserAddress> findAllByUserIdAndDeleteFlagNotOrderByDefaultFlagDescIdDesc(Pageable pageable, Long userId,Boolean delete);

    @Query(value="update   user_address set default_flag =false  where user_id= :userId",nativeQuery=true)
    @Modifying
    int setDefaultFlagById(@Param("userId") Long userId);


    @Query(value="update   user_address set default_flag =true  where  id= :id",nativeQuery=true)
    @Modifying
    int updateDefaultState(@Param("id") Long id);

}
