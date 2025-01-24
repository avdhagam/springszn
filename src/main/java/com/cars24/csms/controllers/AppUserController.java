package com.cars24.csms.controllers;

import com.cars24.csms.data.dao.AppUserDaoImp;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignupRequest;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.data.resp.LoginResponse;
import com.cars24.csms.service.impl.AppUserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Validated
@Slf4j

public class AppUserController {

    private final AppUserDaoImp appUserDao ;
    private final AppUserServiceImpl appUserService;

    @GetMapping
    public ResponseEntity<LoginResponse>  getUsers(@Valid @RequestBody LoginRequest loginRequest){
        appUserDao.getAppUserDetails(loginRequest);
        return ResponseEntity.ok().body(null);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> signUp(@Valid @RequestBody SignupRequest signupRequest){
        log.info("[signUp]  signupRequest {}",signupRequest);
        return appUserService.signUp(signupRequest);
    }




}
