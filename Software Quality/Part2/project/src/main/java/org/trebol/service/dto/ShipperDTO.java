package org.trebol.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link org.trebol.domain.Shipper} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ShipperDTO implements Serializable {

//    @NotNull
    private Long id;

    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShipperDTO)) {
            return false;
        }

        ShipperDTO shipperDTO = (ShipperDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, shipperDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ShipperDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
