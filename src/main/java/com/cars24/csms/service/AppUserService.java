package com.cars24.csms3.service;

import com.cars24.csms3.data.req.LoginRequest;
import com.cars24.csms3.data.req.SignupRequest;
import com.cars24.csms3.data.resp.APIResp;
import com.cars24.csms3.data.resp.LoginResp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface AppUserService {

    public LoginResp getAppUserDetails(LoginRequest loginRequest);
    public ResponseEntity<APIResp> createUser(SignupRequest signupRequest);
}
