package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entity.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
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
    public AppUserDetails getAppUserDetails(LoginReq loginReq) {
        log.info("[getAppUserDetails] loginReq: {}", loginReq);
        AppUserDetails details = appUserRepository.findAppUserDetailsByUsernameAndPassword(
                loginReq.getUsername(),
                loginReq.getPassword()
        );

        if (details == null) {
            log.warn("[getAppUserDetails] User not found for username: {}", loginReq.getUsername());
        }

        return details;
    }

    public void RegisterUser(SignUpReq signUpRequest)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        AppUserDetails appUserDetails = objectMapper.convertValue(signUpRequest,AppUserDetails.class);
        appUserDetails.setEnabled(true);
        appUserRepository.save(appUserDetails);
    }

    public Boolean checkIfUserExists(SignUpReq signUpRequest){
        return  appUserRepository.existsAppUserDetailsByUsername(signUpRequest.getUsername());
    }
    }

