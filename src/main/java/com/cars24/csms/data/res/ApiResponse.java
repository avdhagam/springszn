package com.cars24.csms.data.res;

import lombok.Data;

@Data
public class ApiResponse {
    private Integer statusCode;
    private boolean success;
    private String message;
    private Object data;
    private String service;
}
