package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignupRequest;

public interface AppUserDao {

    String getAppUserDetails(LoginRequest loginRequest);
    String createUser(SignupRequest signUpRequest);
    boolean checkIfUserExists(String username);
    int getUserId(String username);
}



