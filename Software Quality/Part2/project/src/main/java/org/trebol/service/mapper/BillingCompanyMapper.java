package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.BillingCompany;
import org.trebol.service.dto.BillingCompanyDTO;

/**
 * Mapper for the entity {@link BillingCompany} and its DTO {@link BillingCompanyDTO}.
 */
@Mapper(componentModel = "spring")
public interface BillingCompanyMapper extends EntityMapper<BillingCompanyDTO, BillingCompany> {}
