package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    boolean existsByEmail(String email);
}
