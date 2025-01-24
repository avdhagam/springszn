package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserEntity;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignupRequest;


public interface AppUserDao {
    public AppUserEntity getAppUserDetails(LoginRequest loginRequest);
    public void createUser(SignupRequest signupRequest);
}
