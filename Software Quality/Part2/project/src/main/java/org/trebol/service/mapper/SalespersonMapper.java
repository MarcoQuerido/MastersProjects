package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.Person;
import org.trebol.domain.Salesperson;
import org.trebol.service.dto.PersonDTO;
import org.trebol.service.dto.SalespersonDTO;

/**
 * Mapper for the entity {@link Salesperson} and its DTO {@link SalespersonDTO}.
 */
@Mapper(componentModel = "spring")
public interface SalespersonMapper extends EntityMapper<SalespersonDTO, Salesperson> {
    @Mapping(target = "person", source = "person", qualifiedByName = "personId")
    SalespersonDTO toDto(Salesperson s);

    @Named("personId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PersonDTO toDtoPersonId(Person person);
}
