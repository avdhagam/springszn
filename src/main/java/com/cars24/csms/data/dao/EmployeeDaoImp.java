package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.entities.EmployeeEntity;
import com.cars24.csms.data.repositories.EmployeeRepository;
import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.data.resp.CreateEmployeeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeDaoImp implements EmployeeDao{

    private final EmployeeRepository employeeRepository;

    @Override
    public int createEmployee(CreateEmployeeRequest createEmployeeRequest, int userId){
        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId(0); //insert statement
        employeeEntity.setName(createEmployeeRequest.getName()); //insert statement
        employeeEntity.setEmail(createEmployeeRequest.getEmail());
        employeeEntity.setPhone(createEmployeeRequest.getPhone());
        employeeEntity.setRole(createEmployeeRequest.getRole());
        employeeEntity.setSalary(createEmployeeRequest.getSalary());

        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setId(userId);

        employeeEntity.setAppUserDetails(appUserDetails);

        employeeRepository.save(employeeEntity);
        //log.info("[createEmployee] IN DAO");
        return 0;
    }


    public boolean checkIfEmailExists(String email){
        return employeeRepository.existsByEmail(email);
    }



}
