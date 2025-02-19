
package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//import javax.persistence.Column;
//import javax.persistence.Id;
//import javax.persistence.Table;


@Table(name = "employees")
@Entity
@Data
@RequiredArgsConstructor
public class EmployeeEntity {


    @Id
    @Column(name = "employee_id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "salary")
    private int salary;

    @Column(name = "usertype")
    private String usertype;


    @OneToOne
    @JoinColumn (name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private AppUserDetails appUserDetails;

}


