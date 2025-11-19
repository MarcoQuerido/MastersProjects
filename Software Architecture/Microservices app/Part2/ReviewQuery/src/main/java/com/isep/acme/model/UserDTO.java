package com.isep.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;

    private String username;

    private String password;

    private String fullName;

    private Set<RoleDTO> authorities = new HashSet<>();

    private String nif;

    private String morada;

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", authorities=" + authorities +
                ", nif='" + nif + '\'' +
                ", morada='" + morada + '\'' +
                '}';
    }
}
