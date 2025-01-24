package com.cars24.csms.service;

import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpRequest;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    ResponseEntity<APIResponse> signUp(SignUpRequest signUpRequest);

}
