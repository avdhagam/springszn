package com.cars24.csms.controllers;

import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.resp.CreateEmployeeResponse;
import com.cars24.csms.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
@Validated
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest){
        System.out.println("[createEmployee] createEmployeeRequest {}"+ createEmployeeRequest);
        log.info("ENTERING EMPLOYEE CONTROLLER");
        employeeService.createEmployee(createEmployeeRequest);
        CreateEmployeeResponse createEmployeeResponse = new CreateEmployeeResponse();
        return ResponseEntity.ok().body(createEmployeeResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CreateEmployeeResponse> getUsingID(@PathVariable int id){
        //System.out.println("[createEmployee] createEmployeeRequest {}");
        log.info("ENTERED EMPLOYEE CONTROLLER (GET MAPPING)");
        //CreateEmployeeResponse createEmployeeResponse = employeeService.getEmployeeById(id);
        //return ResponseEntity.ok().body(createEmployeeResponse);
        return null;
    }




}

