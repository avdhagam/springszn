package com.cars24.csms.controllers;

import com.cars24.csms.data.dao.impl.AppUserDetailsDaoImpl;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpRequest;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.services.AppUserDetails;
import com.cars24.csms.services.impl.AppUserDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Valid
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user_details")
public class AppUserDetailsController {
    private final AppUserDetailsDaoImpl appUserDetailsDao;
    private final AppUserDetailsImpl appUserDetails;
//    private final AppUserDetailsImpl app
    @PostMapping("/login")
    //this is a read - get request
    public ResponseEntity<?> getAppUserDetails(@RequestBody @Valid LoginRequest loginRequest){
        log.info("Received login request with username: {} and password: {}", loginRequest.getUserName(), loginRequest.getPassword());

        AppUserDetailsEntity appUserDetailsEntity = appUserDetailsDao.getAppUserDetails(loginRequest);

        if (appUserDetailsEntity != null){
            return ResponseEntity.ok(appUserDetailsEntity);
        } else{
            return ResponseEntity.status(401).body("Invalid User name or passworddddd");
        }
    }

//    @PostMapping("/signup")
//    //create method
//    public ResponseEntity<ApiResponse> userSignup(SignUpRequest signUpRequest){
//
//        log.info("[userSignup]: Starting sign up");
//        return appUserDetails.signUpUser(signUpRequest);
//    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        log.info("[signUp] Received signup request: {}", signUpRequest);

        // Check if the user already exists
        if (appUserDetailsDao.userAlreadyExists(signUpRequest)) {
            log.info("[signUp] User already exists with username: {}", signUpRequest.getUserName());

            // Return error response
//            ApiResponse errorResponse = new ApiResponse();
//            errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
//            errorResponse.setSuccess(false);
//            errorResponse.setMessage("User already exists with the given username");
//            errorResponse.setService("APPUSR-" + HttpStatus.BAD_REQUEST.value());
//            errorResponse.setData(null);
//            return ResponseEntity.badRequest().body(errorResponse);
        }


//        return aus.createUser(signUpReq);
        return appUserDetails.signUpUser(signUpRequest);
    }
}
