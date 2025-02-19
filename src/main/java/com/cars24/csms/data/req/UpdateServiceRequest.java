package com.cars24.csms.data.req;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateServiceRequest {
    @NotNull(message = "Service ID is required")
    private Long id;

    @NotBlank(message = "Service name cannot be empty")
    private String name;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;
}
