package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpRequest;

public interface AppUserDetailsDao {
    AppUserDetailsEntity getAppUserDetails(LoginRequest loginRequest);
    void signUpUser(SignUpRequest signUpRequest);
    Boolean userAlreadyExists(SignUpRequest signUpRequest);
}
