package org.trebol.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Sell.
 */
@Entity
@Table(name = "sell")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Sell implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "date", nullable = false)
    private Instant date;

    @NotNull
    @Column(name = "total_items", nullable = false)
    private Integer totalItems;

    @NotNull
    @Column(name = "net_value", nullable = false)
    private Integer netValue;

    @NotNull
    @Column(name = "transport_value", nullable = false)
    private Integer transportValue;

    @NotNull
    @Column(name = "taxes_value", nullable = false)
    private Integer taxesValue;

    @NotNull
    @Column(name = "total_value", nullable = false)
    private Integer totalValue;

    @Size(min = 64, max = 64)
    @Column(name = "transaction_token", length = 64)
    private String transactionToken;

    @OneToMany(mappedBy = "sell")
    @JsonIgnoreProperties(value = { "product", "sell" }, allowSetters = true)
    private Set<SellDetails> details = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "person" }, allowSetters = true)
    private Customer costumer;

    @ManyToOne(optional = false)
    @NotNull
    private PaymentType paymentType;

    @ManyToOne(optional = false)
    @NotNull
    private SellStatus status;

    @ManyToOne(optional = false)
    @NotNull
    private BillingType billingType;

    @ManyToOne
    private BillingCompany billingCompany;

    @ManyToOne
    private Address billingAddress;

    @ManyToOne
    private Shipper shipper;

    @ManyToOne
    private Address shippingAddress;

    @ManyToOne
    @JsonIgnoreProperties(value = { "person" }, allowSetters = true)
    private Salesperson salesperson;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Sell id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return this.date;
    }

    public Sell date(Instant date) {
        this.setDate(date);
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Integer getTotalItems() {
        return this.totalItems;
    }

    public Sell totalItems(Integer totalItems) {
        this.setTotalItems(totalItems);
        return this;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getNetValue() {
        return this.netValue;
    }

    public Sell netValue(Integer netValue) {
        this.setNetValue(netValue);
        return this;
    }

    public void setNetValue(Integer netValue) {
        this.netValue = netValue;
    }

    public Integer getTransportValue() {
        return this.transportValue;
    }

    public Sell transportValue(Integer transportValue) {
        this.setTransportValue(transportValue);
        return this;
    }

    public void setTransportValue(Integer transportValue) {
        this.transportValue = transportValue;
    }

    public Integer getTaxesValue() {
        return this.taxesValue;
    }

    public Sell taxesValue(Integer taxesValue) {
        this.setTaxesValue(taxesValue);
        return this;
    }

    public void setTaxesValue(Integer taxesValue) {
        this.taxesValue = taxesValue;
    }

    public Integer getTotalValue() {
        return this.totalValue;
    }

    public Sell totalValue(Integer totalValue) {
        this.setTotalValue(totalValue);
        return this;
    }

    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    public String getTransactionToken() {
        return this.transactionToken;
    }

    public Sell transactionToken(String transactionToken) {
        this.setTransactionToken(transactionToken);
        return this;
    }

    public void setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
    }

    public Set<SellDetails> getDetails() {
        return this.details;
    }

    public void setDetails(Set<SellDetails> sellDetails) {
        if (this.details != null) {
            this.details.forEach(i -> i.setSell(null));
        }
        if (sellDetails != null) {
            sellDetails.forEach(i -> i.setSell(this));
        }
        this.details = sellDetails;
    }

    public Sell details(Set<SellDetails> sellDetails) {
        this.setDetails(sellDetails);
        return this;
    }

    public Sell addDetails(SellDetails sellDetails) {
        this.details.add(sellDetails);
        sellDetails.setSell(this);
        return this;
    }

    public Sell removeDetails(SellDetails sellDetails) {
        this.details.remove(sellDetails);
        sellDetails.setSell(null);
        return this;
    }

    public Customer getCostumer() {
        return this.costumer;
    }

    public void setCostumer(Customer customer) {
        this.costumer = customer;
    }

    public Sell costumer(Customer customer) {
        this.setCostumer(customer);
        return this;
    }

    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Sell paymentType(PaymentType paymentType) {
        this.setPaymentType(paymentType);
        return this;
    }

    public SellStatus getStatus() {
        return this.status;
    }

    public void setStatus(SellStatus sellStatus) {
        this.status = sellStatus;
    }

    public Sell status(SellStatus sellStatus) {
        this.setStatus(sellStatus);
        return this;
    }

    public BillingType getBillingType() {
        return this.billingType;
    }

    public void setBillingType(BillingType billingType) {
        this.billingType = billingType;
    }

    public Sell billingType(BillingType billingType) {
        this.setBillingType(billingType);
        return this;
    }

    public BillingCompany getBillingCompany() {
        return this.billingCompany;
    }

    public void setBillingCompany(BillingCompany billingCompany) {
        this.billingCompany = billingCompany;
    }

    public Sell billingCompany(BillingCompany billingCompany) {
        this.setBillingCompany(billingCompany);
        return this;
    }

    public Address getBillingAddress() {
        return this.billingAddress;
    }

    public void setBillingAddress(Address address) {
        this.billingAddress = address;
    }

    public Sell billingAddress(Address address) {
        this.setBillingAddress(address);
        return this;
    }

    public Shipper getShipper() {
        return this.shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Sell shipper(Shipper shipper) {
        this.setShipper(shipper);
        return this;
    }

    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(Address address) {
        this.shippingAddress = address;
    }

    public Sell shippingAddress(Address address) {
        this.setShippingAddress(address);
        return this;
    }

    public Salesperson getSalesperson() {
        return this.salesperson;
    }

    public void setSalesperson(Salesperson salesperson) {
        this.salesperson = salesperson;
    }

    public Sell salesperson(Salesperson salesperson) {
        this.setSalesperson(salesperson);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sell)) {
            return false;
        }
        return id != null && id.equals(((Sell) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Sell{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", totalItems=" + getTotalItems() +
            ", netValue=" + getNetValue() +
            ", transportValue=" + getTransportValue() +
            ", taxesValue=" + getTaxesValue() +
            ", totalValue=" + getTotalValue() +
            ", transactionToken='" + getTransactionToken() + "'" +
            "}";
    }
}
