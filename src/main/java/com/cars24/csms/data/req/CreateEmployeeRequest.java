package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Valid
@RequiredArgsConstructor
@Data
public class CreateEmployeeRequest {

    @Valid
    @NotNull()
    @NotBlank
    @Size(max = 50, message = "name too long")
    private String name;

    @Valid
    //@Pattern(regexp = "")
    private String phone;


    @Valid
    @Email
    @NotNull()
    @NotBlank
    @Size(max = 50, message = "email too long")
    private String email;

    private String role;

    @Valid
    @Min(value = 1, message = "invalid salary amount")
    private int salary;


}
