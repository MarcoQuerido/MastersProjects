package com.isep.acme.Authentication;

import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Data
public class AuthenticationRequest {

    @NotNull
    @Email
    String username;
    @NotNull
    String password;
}
