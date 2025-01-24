package com.cars24.csms.service;

import com.cars24.csms.data.req.SignupRequest;
import com.cars24.csms.data.resp.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    ResponseEntity<ApiResponse> signUp (SignupRequest signUpRequest);
}
