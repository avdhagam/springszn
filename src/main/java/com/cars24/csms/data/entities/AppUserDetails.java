package com.cars24.csms.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="app_user_details")
@Data
public class AppUserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id // Marks this field as the primary key.// Auto-generates the ID value.
    @Column(name="id")
    private Integer id;

    @Column(name = "username", nullable = false, unique = true) // Maps the "username" field to a database column.
    private String username;

    @Column(name = "password", nullable = false) // Maps the "password" field to a database column.
    private String password;

    @Column(name = "is_enabled", nullable = false) // Maps the "isEnabled" field to a database column.
    private boolean isEnabled;

}
