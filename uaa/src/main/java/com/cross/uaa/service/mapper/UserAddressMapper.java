package com.cross.uaa.service.mapper;


import com.cross.uaa.domain.*;
import com.cross.uaa.service.dto.UserAddressDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserAddress} and its DTO {@link UserAddressDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserAddressMapper extends EntityMapper<UserAddressDTO, UserAddress> {



    default UserAddress fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserAddress userAddress = new UserAddress();
        userAddress.setId(id);
        return userAddress;
    }
}
