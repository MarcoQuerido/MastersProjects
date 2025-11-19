package com.isep.acme.model.neo4j;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

import com.isep.acme.model.Role;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Node("User")
@Getter
@Setter
public class UserNeo4J implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String fullName;

    @Relationship(type = "HAS_ROLE", direction = INCOMING)
    private Set<Role> authorities = new HashSet<>();

    @Property
    private String nif;

    @Property
    private String morada;

/*    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> review = new ArrayList<Review>(); */

    public UserNeo4J() {}

    public UserNeo4J(final String username, final String password){
        this.username = username;
        this.password = password;
    }


    public UserNeo4J(final String username, final String password, final String fullName, final String nif, final String morada) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        setNif(nif);
        this.morada = morada;
    }

    public void addAuthority(Role r) {
        authorities.add(r);
    }

    public void setNif(String nif) {
        if(nif.length() != 9) {
            throw new IllegalArgumentException("NIF must be 9 characters.");
        }
        this.nif = nif;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

