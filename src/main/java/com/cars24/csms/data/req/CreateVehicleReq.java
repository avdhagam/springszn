package com.cars24.csms.data.req;


import com.cars24.csms.service.impl.VehicleServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;

@Valid
@Data
@RequiredArgsConstructor
public class CreateVehicleReq {

    private final VehicleServiceImpl vehicleServiceImpl;
    @Valid
    @Min(1)
    private int vehicle_id;

    @Valid
    @Min(1)
    private int customer_id;

    @Valid
    @NotNull
    private String make;

    @Valid
    @NotNull
    private String model;

    @Valid
    @NotNull
    private String color;

    @Valid
    @NotNull
    private String license_plate;

    @Valid
    @Min(1900)
    private int year;

    @Override
    public String toString() {
        return "CreateVehicleReq{" +
                "vehicle_id=" + vehicle_id +
                ", customer_id=" + customer_id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", year=" + year +
                '}';
    }
}
