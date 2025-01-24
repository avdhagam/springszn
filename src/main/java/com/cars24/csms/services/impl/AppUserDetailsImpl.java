package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.AppUserDetailsDaoImpl;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.repositories.AppUserDetailsRepository;
import com.cars24.csms.data.req.SignUpRequest;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.AppUserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppUserDetailsImpl implements AppUserDetails {
    ApiResponse response = new ApiResponse();
    private AppUserDetailsDaoImpl appUserDetailsDao;
    private AppUserDetailsRepository appUserDetailsRepository;

    @Autowired
    public AppUserDetailsImpl(AppUserDetailsDaoImpl appUserDetailsDao){
        this.appUserDetailsDao = appUserDetailsDao;
    }
    @Override
    public ResponseEntity<ApiResponse> signUpUser(SignUpRequest signUpRequest) {
        ApiResponse apiResponse = new ApiResponse();

        if(appUserDetailsDao.userAlreadyExists(signUpRequest)){
            //if exists
            throw new UserServiceException("User already exists");
        }
        else {
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setSuccess(true);
            apiResponse.setMessage("User signed up successfully");
            apiResponse.setService("APPUSR-" + HttpStatus.OK.value());
            apiResponse.setData(null);

            appUserDetailsDao.signUpUser(signUpRequest);

            return ResponseEntity.ok().body(apiResponse);
        }
    //throw custom exceptions
    //take whole else part and put it in global exception handler
    //throw new UserServiceException(message = "User  already exists")

}
}
