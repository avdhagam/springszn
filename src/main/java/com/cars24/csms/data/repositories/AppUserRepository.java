package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    public AppUserEntity findAppUserDetailsByUsernameAndPassword(String username, String password);
    Boolean existsByUsername(String username);
}
