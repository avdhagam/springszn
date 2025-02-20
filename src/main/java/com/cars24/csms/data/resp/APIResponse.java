package com.cars24.csms.data.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor  // Default constructor
@AllArgsConstructor // Constructor with all arguments
public class APIResponse {
    private boolean success;

    @Setter
    private int statuscode;

    private String message;
    private String service;
    private Object data; // Holds response data or error messages
}
