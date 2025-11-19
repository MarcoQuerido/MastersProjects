package com.isep.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoleDTO {
    private String authority;

    @Override
    public String toString() {
        return "RoleDTO{" +
                "authority='" + authority + '\'' +
                '}';
    }
}
