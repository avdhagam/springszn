package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Valid
@Data
public class SignUpRequest {
        @Valid

        @Length(max=30, message = "username should be lesser than 30 characters")
        @NotBlank(message = "username cannot be blank")
        @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
                message = "Invalid email format")
        private String username;

        @Valid
        @Size(min=5,max =20, message = "username should be between 5 and 2 characters" )
        @NotBlank(message = "password cannot be blank")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$", message = "Password must contain at least one number and one letter")
        @Pattern(regexp = "\\S+",message = "Password must not contain any whitespaces")
        private String password;

}
