package com.cars24.csms.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class VehicleEntity {
    @Id
    @Column(name = "vehicle_id")
    private int vehicle_id;

    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name = "license_plate")
    private String license_plate;

    @Column(name = "model")
    private String model;

    @Column(name = "make")
    private String make;

    @Column(name = "color")
    private String color;

    @Column(name = "year")
    private int year;


}
