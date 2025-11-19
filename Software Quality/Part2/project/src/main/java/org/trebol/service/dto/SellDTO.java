package org.trebol.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link org.trebol.domain.Sell} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SellDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant date;

    @NotNull
    private Integer totalItems;

    @NotNull
    private Integer netValue;

    @NotNull
    private Integer transportValue;

    @NotNull
    private Integer taxesValue;

    @NotNull
    private Integer totalValue;

    @Size(min = 64, max = 64)
    private String transactionToken;

    private CustomerDTO costumer;

    private PaymentTypeDTO paymentType;

    private SellStatusDTO status;

    private BillingTypeDTO billingType;

    private BillingCompanyDTO billingCompany;

    private AddressDTO billingAddress;

    private ShipperDTO shipper;

    private AddressDTO shippingAddress;

    private SalespersonDTO salesperson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getNetValue() {
        return netValue;
    }

    public void setNetValue(Integer netValue) {
        this.netValue = netValue;
    }

    public Integer getTransportValue() {
        return transportValue;
    }

    public void setTransportValue(Integer transportValue) {
        this.transportValue = transportValue;
    }

    public Integer getTaxesValue() {
        return taxesValue;
    }

    public void setTaxesValue(Integer taxesValue) {
        this.taxesValue = taxesValue;
    }

    public Integer getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    public String getTransactionToken() {
        return transactionToken;
    }

    public void setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
    }

    public CustomerDTO getCostumer() {
        return costumer;
    }

    public void setCostumer(CustomerDTO costumer) {
        this.costumer = costumer;
    }

    public PaymentTypeDTO getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeDTO paymentType) {
        this.paymentType = paymentType;
    }

    public SellStatusDTO getStatus() {
        return status;
    }

    public void setStatus(SellStatusDTO status) {
        this.status = status;
    }

    public BillingTypeDTO getBillingType() {
        return billingType;
    }

    public void setBillingType(BillingTypeDTO billingType) {
        this.billingType = billingType;
    }

    public BillingCompanyDTO getBillingCompany() {
        return billingCompany;
    }

    public void setBillingCompany(BillingCompanyDTO billingCompany) {
        this.billingCompany = billingCompany;
    }

    public AddressDTO getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressDTO billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShipperDTO getShipper() {
        return shipper;
    }

    public void setShipper(ShipperDTO shipper) {
        this.shipper = shipper;
    }

    public AddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public SalespersonDTO getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(SalespersonDTO salesperson) {
        this.salesperson = salesperson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SellDTO)) {
            return false;
        }

        SellDTO sellDTO = (SellDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, sellDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SellDTO{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", totalItems=" + getTotalItems() +
            ", netValue=" + getNetValue() +
            ", transportValue=" + getTransportValue() +
            ", taxesValue=" + getTaxesValue() +
            ", totalValue=" + getTotalValue() +
            ", transactionToken='" + getTransactionToken() + "'" +
            ", costumer=" + getCostumer() +
            ", paymentType=" + getPaymentType() +
            ", status=" + getStatus() +
            ", billingType=" + getBillingType() +
            ", billingCompany=" + getBillingCompany() +
            ", billingAddress=" + getBillingAddress() +
            ", shipper=" + getShipper() +
            ", shippingAddress=" + getShippingAddress() +
            ", salesperson=" + getSalesperson() +
            "}";
    }
}
