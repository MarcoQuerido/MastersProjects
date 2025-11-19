package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.Costumer;
import org.trebol.domain.Person;
import org.trebol.service.dto.CostumerDTO;
import org.trebol.service.dto.PersonDTO;

/**
 * Mapper for the entity {@link Costumer} and its DTO {@link CostumerDTO}.
 */
@Mapper(componentModel = "spring")
public interface CostumerMapper extends EntityMapper<CostumerDTO, Costumer> {
    @Mapping(target = "person", source = "person", qualifiedByName = "personId")
    CostumerDTO toDto(Costumer s);

    @Named("personId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PersonDTO toDtoPersonId(Person person);
}
