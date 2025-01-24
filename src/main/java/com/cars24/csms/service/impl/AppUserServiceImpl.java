package com.cars24.csms.service.impl;

import com.cars24.csms.data.dao.Impl.AppUserDoaImpl;
import com.cars24.csms.data.entities.AppUserEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignupRequest;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.LoginResp;
import com.cars24.csms.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class AppUserServiceImpl implements AppUserService {

    private final AppUserDoaImpl appUserDoaImpl;
    private final AppUserRepository appUserRepository;

    @Override
    public LoginResp getAppUserDetails(LoginRequest loginRequest) {
        AppUserEntity appUserEntity = appUserDoaImpl.getAppUserDetails(loginRequest);

        LoginResp loginResp = new LoginResp();
        loginResp.setUser_id(appUserEntity.getUser_id());
        loginResp.setUsername(appUserEntity.getUsername());
        loginResp.setIs_active(appUserEntity.isActive());

        return loginResp;
    }

    @Override
    public ResponseEntity<APIResponse> createUser(SignupRequest signupRequest) {

        boolean exists = false;
        APIResponse resp = new APIResponse();

        exists = appUserRepository.existsByUsername(signupRequest.getUsername());

        if(!exists) {

            resp.setStatusCode(HttpStatus.OK.value());
            resp.setSuccess(true);
            resp.setMessage("User signed up successfully");
            resp.setService("APPUSR - " + HttpStatus.OK.value());
            resp.setData(null);

            appUserDoaImpl.createUser(signupRequest);

            return ResponseEntity.ok().body(resp);

        }

        else{

            resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
            resp.setSuccess(false);
            resp.setMessage("User already exists please login");
            resp.setService("APPUSR - " + HttpStatus.BAD_REQUEST.value());
            resp.setData(null);

            return ResponseEntity.ok().body(resp);
        }

    }
}
