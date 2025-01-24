package com.cars24.csms3.service;

import com.cars24.csms3.data.req.CreateCustomerReq;
import com.cars24.csms3.data.resp.CreateCustomerResponce;

public interface CustomerService {
    CreateCustomerResponce createCustomer(CreateCustomerReq createCustomerReq);
    CreateCustomerResponce updateCustomer(int id,  CreateCustomerReq createCustomerReq);
    public CreateCustomerResponce getCustomer(int id);
    CreateCustomerResponce updateCustomer(CreateCustomerReq createCustomerReq);
    CreateCustomerResponce deleteCustomer(int id);
}
