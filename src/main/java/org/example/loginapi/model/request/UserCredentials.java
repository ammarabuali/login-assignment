package org.example.loginapi.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCredentials {

    @Email(message = "Please enter a valid email")
    @NotBlank(message = "Email can't be left empty")
    private String email;
    @NotBlank(message = "Password can't be left empty")
    @Size(min = 8, message = "Password is too short")
    private String password;
}

