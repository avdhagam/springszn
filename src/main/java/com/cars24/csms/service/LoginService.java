package com.cars24.csms3.service;

import com.cars24.csms3.data.entity.AppUserEntity;

public interface LoginService {
     AppUserEntity findAppUserDetailsByUNandPass(String UN, String password);
}
