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
    @NotBlank(message = "User name cannot be blank")
    private String userName;

    @Valid
    @NotBlank(message = "password cannot be blank")
    @Size(min=5,max =20, message = "password should be between 5 and 20 characters" )
    private String password;
}
