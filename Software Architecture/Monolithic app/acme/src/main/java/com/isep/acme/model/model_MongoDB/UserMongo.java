package com.isep.acme.model.model_MongoDB;

import com.isep.acme.model.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Getter
@Setter
public class UserMongo implements Serializable {

    @Id
    private String id; // MongoDB uses ObjectId as the default primary key

    private String username;

    private String password;

    @Field
    private String fullName;

    @Field
    private Set<Role> authorities = new HashSet<>();

    @Field
    private String nif;

    @Field
    private String morada;

    public UserMongo(final String username, final String password, String fullName, String nif, final String morada) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setFullname(String fullName){
        this.fullName = fullName;
    }

    public String getFullName(){
        return fullName;
    }

    public void setMorada(String morada){
        this.morada = morada;
    }

    public String getMorada(){
        return morada;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
