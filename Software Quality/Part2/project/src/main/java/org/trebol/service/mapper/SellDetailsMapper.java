package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.Product;
import org.trebol.domain.Sell;
import org.trebol.domain.SellDetails;
import org.trebol.service.dto.ProductDTO;
import org.trebol.service.dto.SellDTO;
import org.trebol.service.dto.SellDetailsDTO;

/**
 * Mapper for the entity {@link SellDetails} and its DTO {@link SellDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface SellDetailsMapper extends EntityMapper<SellDetailsDTO, SellDetails> {
    @Mapping(target = "product", source = "product", qualifiedByName = "productId")
    @Mapping(target = "sell", source = "sell", qualifiedByName = "sellId")
    SellDetailsDTO toDto(SellDetails s);

    @Named("productId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProductDTO toDtoProductId(Product product);

    @Named("sellId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SellDTO toDtoSellId(Sell sell);
}
