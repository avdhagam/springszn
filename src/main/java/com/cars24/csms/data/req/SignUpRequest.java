package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Valid
public class SignUpRequest {

    @NotBlank(message = "User name cannot be blank")
    @Email(message = "Invalid email format")
    @Valid
    @Length(max=30, message = "username should be lesser than 30 characters")
    private String userName;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,20}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    @Pattern(regexp = "\\S+", message = "Password must not contain any white spaces")
    @Valid
    private String password;
}

