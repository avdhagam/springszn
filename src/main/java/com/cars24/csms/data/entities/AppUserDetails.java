// Part of diya's employee code
// need to merge& resolve w app code
// also has her own app user dao and dao imp
// not added yet tho

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
