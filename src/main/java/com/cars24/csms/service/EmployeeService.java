// API Response error
package com.cars24.csms.service;

import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.CreateEmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    ResponseEntity<APIResponse> createEmployee(CreateEmployeeRequest createEmployeeRequest);
    CreateEmployeeResponse getEmployeeById(int id);
}
