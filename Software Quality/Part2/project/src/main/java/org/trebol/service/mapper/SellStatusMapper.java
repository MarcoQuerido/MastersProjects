package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.SellStatus;
import org.trebol.service.dto.SellStatusDTO;

/**
 * Mapper for the entity {@link SellStatus} and its DTO {@link SellStatusDTO}.
 */
@Mapper(componentModel = "spring")
public interface SellStatusMapper extends EntityMapper<SellStatusDTO, SellStatus> {}
