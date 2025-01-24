package com.cars24.csms.data.resp;

import lombok.Data;

@Data
public class ApiResponse {

    private int Status;
    private boolean Success;
    private String Message;
    private Object Data;
    private String Service;
}