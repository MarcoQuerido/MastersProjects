package org.trebol.service.mapper;

import org.mapstruct.*;
import org.trebol.domain.Address;
import org.trebol.domain.BillingCompany;
import org.trebol.domain.BillingType;
import org.trebol.domain.Customer;
import org.trebol.domain.PaymentType;
import org.trebol.domain.Salesperson;
import org.trebol.domain.Sell;
import org.trebol.domain.SellStatus;
import org.trebol.domain.Shipper;
import org.trebol.service.dto.AddressDTO;
import org.trebol.service.dto.BillingCompanyDTO;
import org.trebol.service.dto.BillingTypeDTO;
import org.trebol.service.dto.CustomerDTO;
import org.trebol.service.dto.PaymentTypeDTO;
import org.trebol.service.dto.SalespersonDTO;
import org.trebol.service.dto.SellDTO;
import org.trebol.service.dto.SellStatusDTO;
import org.trebol.service.dto.ShipperDTO;

/**
 * Mapper for the entity {@link Sell} and its DTO {@link SellDTO}.
 */
@Mapper(componentModel = "spring")
public interface SellMapper extends EntityMapper<SellDTO, Sell> {
    @Mapping(target = "costumer", source = "costumer", qualifiedByName = "customerId")
    @Mapping(target = "paymentType", source = "paymentType", qualifiedByName = "paymentTypeId")
    @Mapping(target = "status", source = "status", qualifiedByName = "sellStatusId")
    @Mapping(target = "billingType", source = "billingType", qualifiedByName = "billingTypeId")
    @Mapping(target = "billingCompany", source = "billingCompany", qualifiedByName = "billingCompanyId")
    @Mapping(target = "billingAddress", source = "billingAddress", qualifiedByName = "addressId")
    @Mapping(target = "shipper", source = "shipper", qualifiedByName = "shipperId")
    @Mapping(target = "shippingAddress", source = "shippingAddress", qualifiedByName = "addressId")
    @Mapping(target = "salesperson", source = "salesperson", qualifiedByName = "salespersonId")
    SellDTO toDto(Sell s);

    @Named("customerId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CustomerDTO toDtoCustomerId(Customer customer);

    @Named("paymentTypeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PaymentTypeDTO toDtoPaymentTypeId(PaymentType paymentType);

    @Named("sellStatusId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SellStatusDTO toDtoSellStatusId(SellStatus sellStatus);

    @Named("billingTypeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BillingTypeDTO toDtoBillingTypeId(BillingType billingType);

    @Named("billingCompanyId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BillingCompanyDTO toDtoBillingCompanyId(BillingCompany billingCompany);

    @Named("addressId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    AddressDTO toDtoAddressId(Address address);

    @Named("shipperId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ShipperDTO toDtoShipperId(Shipper shipper);

    @Named("salespersonId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SalespersonDTO toDtoSalespersonId(Salesperson salesperson);
}
