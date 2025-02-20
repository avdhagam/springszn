package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.data.resp.CreateEmployeeResponse;
import java.util.Optional;

public interface EmployeeDao {

    int createEmployee(CreateEmployeeRequest createEmployeeRequest, int userId);

    boolean checkIfEmailExists(String email);

    Optional<CreateEmployeeResponse> getEmployeeById(int id);  // New method
}
