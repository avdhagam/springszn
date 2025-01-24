package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpRequest;
import com.cars24.csms.data.resp.LoginResponse;

public interface AppUserDao {
    String getUserDetails(LoginRequest loginRequest);
    void RegisterUser(SignUpRequest signUpRequest);

    Boolean checkIfUserExists(SignUpRequest signUpRequest);

}
