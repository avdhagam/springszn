package com.cars24.csms.service;

import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.data.resp.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeServices {

    ResponseEntity<ApiResponse> createEmployee(CreateEmployeeRequest createEmployeeRequest);
    //CreateEmployeeResponse getEmployeeById(int id);
}
