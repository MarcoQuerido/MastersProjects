package org.trebol.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Salesperson.
 */
@Entity
@Table(name = "salesperson")
@SuppressWarnings("commonjava:DuplicatedBlocks")
public class Salesperson implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    private Person person;

    // jhipsterneedleentityaddfield  JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Salesperson id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Salesperson person(Person person) {
        this.setPerson(person);
        return this;
    }

    // jhipsterneedleentityaddgetterssetters  JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Salesperson)) {
            return false;
        }
        return id != null && id.equals(((Salesperson) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/howtoimplementequalsandhashcodeusingthejpaentityidentifier/
        return getClass().hashCode();
    }

    // prettierignore
    @Override
    public String toString() {
        return "Salesperson{" +
            "id=" + getId() +
            "}";
    }
}
