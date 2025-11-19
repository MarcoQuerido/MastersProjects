package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.PaymentType;
import org.trebol.service.dto.PaymentTypeDTO;

/**
 * Mapper for the entity {@link PaymentType} and its DTO {@link PaymentTypeDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentTypeMapper extends EntityMapper<PaymentTypeDTO, PaymentType> {}
