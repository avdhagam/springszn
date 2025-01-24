package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Valid
@Data
public class SignupRequest {
    @Valid
    @Size(min=5,max =40, message = "username should be between 5 and 20 characters" )
    @NotBlank
    private String username;

    @Valid
    @Size(min=5,max =20, message = "password should be between 5 and 20 characters" )
    @NotBlank
    private String password;
}