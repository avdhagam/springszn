package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.entities.AppUserEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignupRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class AppUserDoaImpl implements AppUserDao {
    private final AppUserRepository appUserRepository;

    @Override
    public AppUserEntity getAppUserDetails(LoginRequest loginRequest){
        return appUserRepository.findAppUserDetailsByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @Override
    public String createUser(SignupRequest signUpRequest)
    {
        log.info("[createUser] IN DAO");
        ObjectMapper objectMapper = new ObjectMapper();
        AppUserDetails appUserDetails = objectMapper.convertValue(signUpRequest,AppUserDetails.class);

        appUserDetails.setEnabled(true);
        appUserRepository.save(appUserDetails);
        return "";
    }

    @Override
    public boolean checkIfUserExists(String username){
        log.info("[checkIfUserExists] IN DAO");
        return  appUserRepository.existsByUsername(username);
    }

    @Override
    public int getUserId(String username) {
        AppUserDetails appUserDetails = appUserRepository.findByUsername(username);
        int userId = appUserDetails.getId();
        log.info("[getUserId] IN DAO : {}", userId);
        return userId;
    }
}
