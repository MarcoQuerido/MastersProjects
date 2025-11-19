package org.trebol.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(max = 200)
    @Column(name = "name", length = 200, nullable = false, unique = true)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(name = "barcode", length = 50, nullable = false, unique = true)
    private String barcode;

    @Size(max = 4000)
    @Column(name = "description", length = 4000)
    private String description;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;

    @NotNull
    @Column(name = "stock_current", nullable = false)
    private Integer stockCurrent;

    @NotNull
    @Column(name = "stock_critical", nullable = false)
    private Integer stockCritical;

    @ManyToOne
    @JsonIgnoreProperties(value = { "parent" }, allowSetters = true)
    private ProductCategory productCategory;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Product id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Product name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public Product barcode(String barcode) {
        this.setBarcode(barcode);
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return this.description;
    }

    public Product description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Product price(Integer price) {
        this.setPrice(price);
        return this;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockCurrent() {
        return this.stockCurrent;
    }

    public Product stockCurrent(Integer stockCurrent) {
        this.setStockCurrent(stockCurrent);
        return this;
    }

    public void setStockCurrent(Integer stockCurrent) {
        this.stockCurrent = stockCurrent;
    }

    public Integer getStockCritical() {
        return this.stockCritical;
    }

    public Product stockCritical(Integer stockCritical) {
        this.setStockCritical(stockCritical);
        return this;
    }

    public void setStockCritical(Integer stockCritical) {
        this.stockCritical = stockCritical;
    }

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Product productCategory(ProductCategory productCategory) {
        this.setProductCategory(productCategory);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", barcode='" + getBarcode() + "'" +
            ", description='" + getDescription() + "'" +
            ", price=" + getPrice() +
            ", stockCurrent=" + getStockCurrent() +
            ", stockCritical=" + getStockCritical() +
            "}";
    }
}
