package com.isep.acme.model.neo4j;

import java.util.Objects;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import com.isep.acme.model.ProductDTO;
import lombok.Getter;
import lombok.Setter;

@Node("Product")
@Getter
@Setter
public class ProductNeo4J {

    @Id
    @GeneratedValue
    private Long id;
    @Property
    public String sku;

    @Property
    private String designation;

    @Property
    private String description;
    /*
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> review = new ArrayList<Review>(); */

    public ProductNeo4J() {
    }

    public ProductNeo4J(final Long productID, final String sku) {
        this.id = Objects.requireNonNull(productID);
        setSku(sku);
    }

    public ProductNeo4J(final Long productID, final String sku, final String designation, final String description) {
        this(productID, sku);
        setDescription(description);
        setDesignation(designation);
    }

    public ProductNeo4J(final String sku) {
        setSku(sku);
    }

    public ProductNeo4J(final String sku, final String designation, final String description) {
        this(sku);
        setDescription(description);
        setDesignation(designation);
    }

    public void setSku(String sku) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU is a mandatory attribute of Product.");
        }
        if (sku.length() != 12) {
            throw new IllegalArgumentException("SKU must be 12 characters long.");
        }

        this.sku = sku;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        if (designation == null || designation.isBlank()) {
            throw new IllegalArgumentException("Designation is a mandatory attribute of Product.");
        }
        if (designation.length() > 50) {
            throw new IllegalArgumentException("Designation must not be greater than 50 characters.");
        }
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description is a mandatory attribute of Product.");
        }

        if (description.length() > 1200) {
            throw new IllegalArgumentException("Description must not be greater than 1200 characters.");
        }

        this.description = description;
    }

    public void updateProduct(ProductNeo4J p) {
        setDesignation(p.designation);
        setDescription(p.description);
    }

    public Long getProductID() {
        return id;
    }

    public ProductDTO toDto() {
        return new ProductDTO(this.sku, this.designation);
    }

}
