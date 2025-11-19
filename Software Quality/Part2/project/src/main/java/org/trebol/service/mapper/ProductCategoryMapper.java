package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.ProductCategory;
import org.trebol.service.dto.ProductCategoryDTO;

/**
 * Mapper for the entity {@link ProductCategory} and its DTO {@link ProductCategoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends EntityMapper<ProductCategoryDTO, ProductCategory> {
    @Mapping(target = "parent", source = "parent", qualifiedByName = "productCategoryId")
    ProductCategoryDTO toDto(ProductCategory s);

    @Named("productCategoryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProductCategoryDTO toDtoProductCategoryId(ProductCategory productCategory);
}
