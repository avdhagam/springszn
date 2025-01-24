package com.cars24.csms.controllers;

import com.cars24.csms.data.dao.Impl.AppUserDaoImpl;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpRequest;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.LoginResponse;
import com.cars24.csms.service.AppUserService;
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
    private final AppUserDaoImpl appUserDao ;
    private final AppUserServiceImpl appUserService;

    @GetMapping
//    public ResponseEntity<LoginResponse> getUsers(@Valid @RequestBody loginRequest){
    public  ResponseEntity<LoginResponse>  getUsers(@Valid @RequestBody LoginRequest loginRequest){
        appUserDao.getUserDetails(loginRequest);
        //comment
        return ResponseEntity.ok().body(null);
    }

    @PostMapping
    public ResponseEntity<APIResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest){
        log.info("[signUp]  signUpRequest {}",signUpRequest);
        return appUserService.signUp(signUpRequest);
    }

}
