package com.cars24.csms.service.impl;

import com.cars24.csms.data.dao.Impl.AppUserDaoImpl;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpRequest;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.service.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserDaoImpl appUserDao;
    private final AppUserRepository appUserRepository;

    @Override
    public ResponseEntity<APIResponse> signUp(SignUpRequest signUpRequest) {
        APIResponse apiResponse = new APIResponse();

        if(appUserDao.checkIfUserExists(signUpRequest)){
            //if exists
           throw new UserServiceException("User already exists");
        }
        else {
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setSuccess(true);
            apiResponse.setMessage("User signed up successfully");
            apiResponse.setService("APPUSR-" + HttpStatus.OK.value());
            apiResponse.setData(null);

            appUserDao.RegisterUser(signUpRequest);

            return ResponseEntity.ok().body(apiResponse);
        }

    }

}
