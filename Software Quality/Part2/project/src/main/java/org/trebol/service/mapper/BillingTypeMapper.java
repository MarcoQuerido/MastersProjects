package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.BillingType;
import org.trebol.service.dto.BillingTypeDTO;

/**
 * Mapper for the entity {@link BillingType} and its DTO {@link BillingTypeDTO}.
 */
@Mapper(componentModel = "spring")
public interface BillingTypeMapper extends EntityMapper<BillingTypeDTO, BillingType> {}
