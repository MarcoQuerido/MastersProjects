package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.Customer;
import org.trebol.domain.Person;
import org.trebol.service.dto.CustomerDTO;
import org.trebol.service.dto.PersonDTO;

/**
 * Mapper for the entity {@link Customer} and its DTO {@link CustomerDTO}.
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
    @Mapping(target = "person", source = "person", qualifiedByName = "personId")
    CustomerDTO toDto(Customer s);

    @Named("personId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PersonDTO toDtoPersonId(Person person);
}
