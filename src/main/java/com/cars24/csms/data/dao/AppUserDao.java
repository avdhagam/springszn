package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;

public interface AppUserDao {
    public AppUserDetails getAppUserDetails(LoginReq loginReq);
    void RegisterUser(SignUpReq signUpRequest);
    Boolean checkIfUserExists(SignUpReq signUpRequest);
}
