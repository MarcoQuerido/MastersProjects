package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.Shipper;
import org.trebol.service.dto.ShipperDTO;

/**
 * Mapper for the entity {@link Shipper} and its DTO {@link ShipperDTO}.
 */
@Mapper(componentModel = "spring")
public interface ShipperMapper extends EntityMapper<ShipperDTO, Shipper> {}
