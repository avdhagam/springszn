package com.cars24.csms.controllers;

import com.cars24.csms.data.dao.Impl.AppUserDaoImpl;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.LoginRes;
import com.cars24.csms.service.AppUserService;
import com.cars24.csms.service.impl.AppUserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.cars24.csms.data.entities.AppUserDetails;

import jakarta.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Validated
@Slf4j
public class AppUserController {
    private final AppUserDaoImpl appUserDao ;
    private final AppUserServiceImpl appUserService;

    @GetMapping
    public ResponseEntity<AppUserDetails> getUsers(@Valid @RequestBody LoginReq loginReq) {
        log.info("[getUsers] loginReq: {}", loginReq);
        AppUserDetails userDetails = appUserDao.getAppUserDetails(loginReq);

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404 if user not found
        }

        return ResponseEntity.ok(userDetails); // 200 OK if user found
    }


    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signUp(@Valid @RequestBody SignUpReq signUpReq){
        log.info("[signUp]  signUpRequest {}",signUpReq);
        return appUserService.createUser(signUpReq);
    }
    //change added

}