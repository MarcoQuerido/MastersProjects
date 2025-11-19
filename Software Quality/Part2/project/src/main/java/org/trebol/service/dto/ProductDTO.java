package org.trebol.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link org.trebol.domain.Product} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 200)
    private String name;

    @NotNull
    @Size(max = 50)
    private String barcode;

    @Size(max = 4000)
    private String description;

    @NotNull
    private Integer price;

    @NotNull
    private Integer stockCurrent;

    @NotNull
    private Integer stockCritical;

    private ProductCategoryDTO productCategory;

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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockCurrent() {
        return stockCurrent;
    }

    public void setStockCurrent(Integer stockCurrent) {
        this.stockCurrent = stockCurrent;
    }

    public Integer getStockCritical() {
        return stockCritical;
    }

    public void setStockCritical(Integer stockCritical) {
        this.stockCritical = stockCritical;
    }

    public ProductCategoryDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryDTO productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        ProductDTO productDTO = (ProductDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", barcode='" + getBarcode() + "'" +
            ", description='" + getDescription() + "'" +
            ", price=" + getPrice() +
            ", stockCurrent=" + getStockCurrent() +
            ", stockCritical=" + getStockCritical() +
            ", productCategory=" + getProductCategory() +
            "}";
    }
}
