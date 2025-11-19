package org.trebol.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link org.trebol.domain.SellDetails} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SellDetailsDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer units;

    @NotNull
    private Integer unitValue;

    @NotNull
    private String description;

    private ProductDTO product;

    private SellDTO sell;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Integer unitValue) {
        this.unitValue = unitValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public SellDTO getSell() {
        return sell;
    }

    public void setSell(SellDTO sell) {
        this.sell = sell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SellDetailsDTO)) {
            return false;
        }

        SellDetailsDTO sellDetailsDTO = (SellDetailsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, sellDetailsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SellDetailsDTO{" +
            "id=" + getId() +
            ", units=" + getUnits() +
            ", unitValue=" + getUnitValue() +
            ", description='" + getDescription() + "'" +
            ", product=" + getProduct() +
            ", sell=" + getSell() +
            "}";
    }
}
