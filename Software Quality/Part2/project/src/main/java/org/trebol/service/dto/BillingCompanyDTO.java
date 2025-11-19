package org.trebol.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link org.trebol.domain.BillingCompany} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BillingCompanyDTO implements Serializable {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 20)
    private String idNumber;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BillingCompanyDTO)) {
            return false;
        }

        BillingCompanyDTO billingCompanyDTO = (BillingCompanyDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, billingCompanyDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BillingCompanyDTO{" +
            "id=" + getId() +
            ", idNumber='" + getIdNumber() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
