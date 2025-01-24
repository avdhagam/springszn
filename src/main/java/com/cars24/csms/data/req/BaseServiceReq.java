package com.cars24.csms.data.req;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Valid
@Data
public abstract class BaseServiceReq {
    @Valid
    @NotBlank(message = "Service name is required")
    private String name;

}
