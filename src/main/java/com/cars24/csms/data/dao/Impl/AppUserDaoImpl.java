package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserDaoImpl implements AppUserDao {
    private final AppUserRepository appUserRepository;

    @Override
    public String getUserDetails(LoginRequest loginRequest){
        AppUserDetails appUserDetails = appUserRepository.findAppUserDetailsByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
        log.info(String.valueOf(appUserDetails));
        return null;
    }

    public void RegisterUser(SignUpRequest signUpRequest)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        AppUserDetails appUserDetails = objectMapper.convertValue(signUpRequest,AppUserDetails.class);
        appUserDetails.setEnabled(true);
        appUserRepository.save(appUserDetails);
    }

    public Boolean checkIfUserExists(SignUpRequest signUpRequest){
        return  appUserRepository.existsAppUserDetailsByUsername(signUpRequest.getUsername());
    }
}
