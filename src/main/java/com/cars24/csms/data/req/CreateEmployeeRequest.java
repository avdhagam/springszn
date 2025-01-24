package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



}
