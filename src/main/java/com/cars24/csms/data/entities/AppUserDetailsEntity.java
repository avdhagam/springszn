package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class AppUserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    Integer userId;

    @Column(name = "user_name",nullable = false)
    String userName;

    @Column(name = "password",nullable = false)
    String password;

    @Column(name = "isEnabled")
    boolean isEnabled;
}
