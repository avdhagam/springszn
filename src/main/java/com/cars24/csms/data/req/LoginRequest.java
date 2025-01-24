package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Valid
@Data
public class LoginRequest {
    @Valid
    @Length(max=30, message = "username should be lesser than 30 characters")
    @NotBlank(message = "username cannot be blank")
    private String username;

    @Valid
    @Size(min=5,max =20, message = "username should be between 5 and 2 characters" )
    @NotBlank(message = "password cannot be blank")
    private String password;
}
