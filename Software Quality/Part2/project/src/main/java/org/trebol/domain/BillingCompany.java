package org.trebol.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A BillingCompany.
 */
@Entity
@Table(name = "billing_company")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BillingCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_number", length = 20, nullable = false, unique = true)
    private String idNumber;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public BillingCompany id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public BillingCompany idNumber(String idNumber) {
        this.setIdNumber(idNumber);
        return this;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return this.name;
    }

    public BillingCompany name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BillingCompany)) {
            return false;
        }
        return id != null && id.equals(((BillingCompany) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BillingCompany{" +
            "id=" + getId() +
            ", idNumber='" + getIdNumber() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
