package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.Address;
import org.trebol.service.dto.AddressDTO;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {}
