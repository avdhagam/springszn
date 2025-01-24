package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AppUserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String username;
    private String password;
    private boolean isEnabled;

    @OneToOne(mappedBy = "appUserDetails")
    private EmployeeEntity employeeEntity;
}
