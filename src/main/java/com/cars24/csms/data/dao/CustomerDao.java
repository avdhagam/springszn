package com.cars24.csms3.data.dao;

import com.cars24.csms3.data.req.CreateCustomerReq;
import com.cars24.csms3.data.resp.CreateCustomerResponce;
import org.springframework.stereotype.Service;

@Service
public interface CustomerDao {
    int createCustomer(CreateCustomerReq createCustomerReq);  // Method to create a customer

    int updateCustomer(int id, CreateCustomerReq createCustomerReq);

    CreateCustomerResponce getCustomer(int id);

    CreateCustomerResponce deleteCustomer(int id);
}
