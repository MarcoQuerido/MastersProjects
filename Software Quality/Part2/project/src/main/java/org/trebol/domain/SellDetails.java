package org.trebol.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A SellDetails.
 */
@Entity
@Table(name = "sell_details")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SellDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "units", nullable = false)
    private Integer units;

    @NotNull
    @Column(name = "unit_value", nullable = false)
    private Integer unitValue;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "productCategory" }, allowSetters = true)
    private Product product;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(
        value = {
            "details",
            "costumer",
            "paymentType",
            "status",
            "billingType",
            "billingCompany",
            "billingAddress",
            "shipper",
            "shippingAddress",
            "salesperson",
        },
        allowSetters = true
    )
    private Sell sell;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public SellDetails id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUnits() {
        return this.units;
    }

    public SellDetails units(Integer units) {
        this.setUnits(units);
        return this;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getUnitValue() {
        return this.unitValue;
    }

    public SellDetails unitValue(Integer unitValue) {
        this.setUnitValue(unitValue);
        return this;
    }

    public void setUnitValue(Integer unitValue) {
        this.unitValue = unitValue;
    }

    public String getDescription() {
        return this.description;
    }

    public SellDetails description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SellDetails product(Product product) {
        this.setProduct(product);
        return this;
    }

    public Sell getSell() {
        return this.sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }

    public SellDetails sell(Sell sell) {
        this.setSell(sell);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SellDetails)) {
            return false;
        }
        return id != null && id.equals(((SellDetails) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SellDetails{" +
            "id=" + getId() +
            ", units=" + getUnits() +
            ", unitValue=" + getUnitValue() +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
