package com.cars24.csms.service.impl;

import com.cars24.csms.data.dao.AppUserDaoImp;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.SignupRequest;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserDaoImp appUserDao;
    private final AppUserRepository appUserRepository;

    @Override
    public ResponseEntity<ApiResponse> signUp(SignupRequest signUpRequest) {

        boolean res = appUserDao.checkIfUserExists(signUpRequest.getUsername());
        ApiResponse apiResponse = new ApiResponse();

        if (res) {
            //if exists
            throw new UserServiceException("User already exists");
        } else {
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setSuccess(true);
            apiResponse.setMessage("User signed up successfully");
            apiResponse.setService("APP-USR-" + HttpStatus.OK.value());
            apiResponse.setData(null);

            appUserDao.createUser(signUpRequest);
        }
        log.info("[signup] API RESPONSE IN SERVICE: {}", apiResponse);
        return ResponseEntity.ok().body(apiResponse);
    }

}
