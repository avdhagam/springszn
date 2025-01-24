package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppUserDetailsDao;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.repositories.AppUserDetailsRepository;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpRequest;
import com.cars24.csms.exceptions.UserServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import .RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Repository
public class AppUserDetailsDaoImpl implements AppUserDetailsDao {
    private final AppUserDetailsRepository appUserDetailsRepository;
//    log.info("App user details dao impl initialized");
    @Override
    public AppUserDetailsEntity getAppUserDetails(LoginRequest loginRequest) {

        AppUserDetailsEntity appUserDetailsEntity = appUserDetailsRepository.findAppUserByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
        log.info("fetched id: {} and username: {}", loginRequest.getUserName(), loginRequest.getPassword());

        return appUserDetailsEntity;
    }

    @Override
    public void signUpUser(SignUpRequest signUpRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        AppUserDetailsEntity appUserDetails = objectMapper.convertValue(signUpRequest, AppUserDetailsEntity.class);
        appUserDetails.setEnabled(true);

        if(appUserDetailsRepository.existsUserByUserName(appUserDetails.getUserName())){
            throw new UserServiceException("User already exists");
        }

        appUserDetailsRepository.save(appUserDetails);
    }

    @Override
    public Boolean userAlreadyExists(SignUpRequest signUpRequest) {
        return appUserDetailsRepository.existsUserByUserName(signUpRequest.getUserName());
    }
}
