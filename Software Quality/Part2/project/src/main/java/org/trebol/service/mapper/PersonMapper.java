package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.Person;
import org.trebol.service.dto.PersonDTO;

/**
 * Mapper for the entity {@link Person} and its DTO {@link PersonDTO}.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {}
