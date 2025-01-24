package com.cars24.csms3.data.dao;

import com.cars24.csms3.data.entity.AppUserEntity;
import com.cars24.csms3.data.req.LoginRequest;
import com.cars24.csms3.data.req.SignupRequest;
import org.springframework.stereotype.Service;


public interface AppUserDao {
    public AppUserEntity getAppUserDetails(LoginRequest loginRequest);
    public void createUser(SignupRequest signupRequest);
}
