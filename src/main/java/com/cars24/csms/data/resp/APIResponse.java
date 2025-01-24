package com.cars24.csms.data.resp;

import lombok.Data;

@Data
public class APIResponse {
    private int Status;
    private boolean Success;
    private String message;
    private Object data;
    private String Service;
}
