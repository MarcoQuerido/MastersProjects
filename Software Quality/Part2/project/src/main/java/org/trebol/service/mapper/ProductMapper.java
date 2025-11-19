package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.Product;
import org.trebol.domain.ProductCategory;
import org.trebol.service.dto.ProductCategoryDTO;
import org.trebol.service.dto.ProductDTO;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
    @Mapping(target = "productCategory", source = "productCategory", qualifiedByName = "productCategoryId")
    ProductDTO toDto(Product s);

    @Named("productCategoryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProductCategoryDTO toDtoProductCategoryId(ProductCategory productCategory);
}
