package com.cars24.csms.data.req;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateServiceReq {
    @NotBlank(message = "Current service name is required")
    private String currentName; // The current name of the service to identify the record


    private String updatedName; // The new name to update


    @DecimalMin(value = "0.0", inclusive = false, message = "Updated price must be greater than 0")
    private Double updatedPrice; // The new price to update

    // Getters and Setters
    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public Double getUpdatedPrice() {
        return updatedPrice;
    }

    public void setUpdatedPrice(Double updatedPrice) {
        this.updatedPrice = updatedPrice;
    }
}
