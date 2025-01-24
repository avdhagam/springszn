package com.cars24.csms.data.resp;

import lombok.Data;

@Data
public class LoginResp {

    private int user_id;
    private String username;
    private Boolean is_active;

}
