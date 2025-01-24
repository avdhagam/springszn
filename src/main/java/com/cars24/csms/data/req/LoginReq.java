package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Valid
@Data
public class LoginReq {
    @Valid
    @Email(message = "Invalid email format")
    @Size(min = 8, max = 40, message = "Email must be between 8 and 20 characters")
    @NotBlank(message = "username(email) cannot be blank")
    private String username;
    @Valid
    @NotBlank(message = "password cannot be blank")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;
}
