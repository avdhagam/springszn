package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppUserDetails;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository extends JpaRepository<AppUserDetails,Integer> {

      AppUserDetails findAppUserDetailsByUsernameAndPassword(String username, String password);

      boolean existsByUsername(String username);

      AppUserDetails findByUsername(String username);
}
