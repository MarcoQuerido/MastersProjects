package org.trebol.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link org.trebol.domain.Salesperson} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SalespersonDTO implements Serializable {


    private Long id;

    private PersonDTO person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalespersonDTO)) {
            return false;
        }

        SalespersonDTO salespersonDTO = (SalespersonDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, salespersonDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalespersonDTO{" +
            "id=" + getId() +
            ", person=" + getPerson() +
            "}";
    }
}
