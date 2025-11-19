package org.trebol.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link org.trebol.domain.SellStatus} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SellStatusDTO implements Serializable {

    @NotNull
    private Long id;

    @NotNull
    private Integer code;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
        if (!(o instanceof SellStatusDTO)) {
            return false;
        }

        SellStatusDTO sellStatusDTO = (SellStatusDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, sellStatusDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SellStatusDTO{" +
            "id=" + getId() +
            ", code=" + getCode() +
            ", name='" + getName() + "'" +
            "}";
    }
}
