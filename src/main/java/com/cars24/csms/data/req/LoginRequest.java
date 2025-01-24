package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Valid
public class LoginRequest{

    @Valid
    @Size(min=5,max =20, message = "username should be between 5 and 2 characters")
    @NotBlank(message = "username cannot be empty")
    private String username;

    @Valid
    @Size(min=5,max =20, message = "username should be between 5 and 2 characters")
    @NotBlank(message = "password cannot be empty")
    private String password;
}
