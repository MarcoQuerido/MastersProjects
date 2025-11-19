package org.trebol.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link org.trebol.domain.ProductCategory} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductCategoryDTO implements Serializable {

//    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String code;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    private ProductCategoryDTO parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategoryDTO getParent() {
        return parent;
    }

    public void setParent(ProductCategoryDTO parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductCategoryDTO)) {
            return false;
        }

        ProductCategoryDTO productCategoryDTO = (ProductCategoryDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productCategoryDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCategoryDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", parent=" + getParent() +
            "}";
    }
}
