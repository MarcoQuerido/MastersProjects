package com.isep.acme.model.neo4j;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.isep.acme.model.ImageDTO;
import lombok.Getter;
import lombok.Setter;

@Node("ProdImage")
@Getter
@Setter
public class ProdImageNeo4J {

    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "BELONGS_TO_PRODUCT")
    private ProductNeo4J productNeo4J;

    private byte[] image;

    public ProdImageNeo4J(ProductNeo4J productNeo4J, byte[] image) {
        setProduct(productNeo4J);
        //addImage(image);;

    }

    public ProdImageNeo4J() {

    }

    private void setProduct(ProductNeo4J productNeo4J) {
    }

    public ImageDTO toDto() {
        return new ImageDTO(this.id, productNeo4J.getProductID());
    }

/*
    public ImageService addImage( Resource image){

        return new AddImage (this.image);
    }
*/
}

