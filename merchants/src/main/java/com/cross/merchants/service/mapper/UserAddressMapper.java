package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.UserAddress;
import com.cross.merchants.service.dto.UserAddressDTO;
import org.mapstruct.Mapper;

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
