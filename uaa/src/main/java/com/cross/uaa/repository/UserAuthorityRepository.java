package com.cross.uaa.repository;

import com.cross.uaa.domain.Authority;
import com.cross.uaa.domain.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {


    List<UserAuthority> findAllByAuthorityName(String name);


}
