package org.trebol.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Address.
 */
@Entity
@Table(name = "address")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @NotNull
    @Size(max = 50)
    @Column(name = "municipality", length = 50, nullable = false)
    private String municipality;

    @NotNull
    @Size(max = 100)
    @Column(name = "first_line", length = 100, nullable = false)
    private String firstLine;

    @Size(max = 50)
    @Column(name = "second_line", length = 50)
    private String secondLine;

    @Column(name = "postal_code")
    private String postalCode;

    @Size(max = 50)
    @Column(name = "notes", length = 50)
    private String notes;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Address id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public Address city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMunicipality() {
        return this.municipality;
    }

    public Address municipality(String municipality) {
        this.setMunicipality(municipality);
        return this;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getFirstLine() {
        return this.firstLine;
    }

    public Address firstLine(String firstLine) {
        this.setFirstLine(firstLine);
        return this;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return this.secondLine;
    }

    public Address secondLine(String secondLine) {
        this.setSecondLine(secondLine);
        return this;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public Address postalCode(String postalCode) {
        this.setPostalCode(postalCode);
        return this;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNotes() {
        return this.notes;
    }

    public Address notes(String notes) {
        this.setNotes(notes);
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        return id != null && id.equals(((Address) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Address{" +
            "id=" + getId() +
            ", city='" + getCity() + "'" +
            ", municipality='" + getMunicipality() + "'" +
            ", firstLine='" + getFirstLine() + "'" +
            ", secondLine='" + getSecondLine() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
