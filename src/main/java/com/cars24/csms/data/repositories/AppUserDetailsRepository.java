package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppUserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserDetailsRepository extends JpaRepository<AppUserDetailsEntity, Integer> {
    public AppUserDetailsEntity findAppUserByUserNameAndPassword(String userName, String password);
    public boolean existsUserByUserName(String userName);
}
