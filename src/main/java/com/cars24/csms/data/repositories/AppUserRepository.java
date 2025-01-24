package com.cars24.csms3.data.repositories;

import com.cars24.csms3.data.entity.AppUserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity, Integer> {
      boolean existsByUsername(@Email @NotBlank String email);

      public AppUserEntity findAppUserDetailsByUsernameAndPassword(String username, String password);

}
