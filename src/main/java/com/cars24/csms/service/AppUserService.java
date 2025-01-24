package com.cars24.csms.service;

import com.cars24.csms.data.entity.AppUserDetails;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public interface AppUserService {
    ResponseEntity<APIResponse> createUser(SignUpReq signUpRequest);

}
