package com.cars24.csms3.service.impl;

import com.cars24.csms3.data.dao.CustomerDao;
import com.cars24.csms3.data.entity.CustomerEntity;
import com.cars24.csms3.data.repositories.AppUserRepository;
import com.cars24.csms3.data.repositories.CustomerRepository;
import com.cars24.csms3.data.req.CreateCustomerReq;
import com.cars24.csms3.data.resp.CreateCustomerResponce;
import com.cars24.csms3.exceptions.CheckByUsername;
import com.cars24.csms3.exceptions.UserExistsException;
import com.cars24.csms3.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerDao customerDao;
    private final AppUserRepository appUserRepository;
    private final CustomerRepository customerRepository;

    @Override
    public CreateCustomerResponce createCustomer(CreateCustomerReq createCustomerReq) {

        // Check if the username exists in the AppUser table
        boolean userExists = appUserRepository.existsByUsername(createCustomerReq.getEmail());

        // Check if the customer already exists in the Customer table
        boolean customerExists = customerRepository.existsByEmail(createCustomerReq.getEmail());

        if (userExists) {
            if (!customerExists) {
                // Create the customer
                customerDao.createCustomer(createCustomerReq);

                // Populate and return the response
                CreateCustomerResponce response = new CreateCustomerResponce();
                response.setName(createCustomerReq.getName());
                response.setPhone(createCustomerReq.getPhone());
                response.setEmail(createCustomerReq.getEmail());
                response.setAddress(createCustomerReq.getAddress());
                return response;
            } else {
                // Customer already exists
                throw new UserExistsException("The user with the given email already exists as a customer.");
            }
        } else {
            // Username does not exist in the AppUser table
            throw new CheckByUsername("The user with this email does not exist. Please sign up first.");
        }

//        CreateCustomerResponce response = new CreateCustomerResponce();
//        response.setName(createCustomerReq.getName());
//        response.setPhone(createCustomerReq.getPhone());
//        response.setEmail(createCustomerReq.getEmail());
//       response.setAddress(createCustomerReq.getAddress());

    }

    @Override
    public CreateCustomerResponce updateCustomer(int id, CreateCustomerReq createCustomerReq) {

        boolean userExists = appUserRepository.existsByUsername(createCustomerReq.getEmail());



        if (userExists) {
        {
                // Create the customer
                customerDao.updateCustomer(id, createCustomerReq);

                // Populate and return the response
                CreateCustomerResponce response = new CreateCustomerResponce();
                response.setName(createCustomerReq.getName());
                response.setPhone(createCustomerReq.getPhone());
                response.setEmail(createCustomerReq.getEmail());
                response.setAddress(createCustomerReq.getAddress());
                return response;
            }
        } else {
            // Username does not exist in the AppUser table
            throw new CheckByUsername("The user with this email does not exist. Please sign up first.");
        }

    }

    @Override
    public CreateCustomerResponce updateCustomer(CreateCustomerReq createCustomerReq) {

        return null;
    }


    @Override
    public CreateCustomerResponce getCustomer(int id) {
       CreateCustomerResponce createCustomerResponce =  customerDao.getCustomer(id);

        boolean userExists = appUserRepository.existsByUsername(createCustomerResponce.getEmail());



        if (userExists) {
            {
                // Create the customer
                customerDao.getCustomer(id);

                // Populate and return the response

                return createCustomerResponce;
            }
        } else {
            // Username does not exist in the AppUser table
            throw new CheckByUsername("The user with this email does not exist. Please sign up first.");
        }

    }

    @Override
    public CreateCustomerResponce deleteCustomer(int id) {

        CreateCustomerResponce createCustomerResponce =  customerDao.getCustomer(id);

        boolean userExists = appUserRepository.existsByUsername(createCustomerResponce.getEmail());



        if (userExists) {
            {
                // Create the customer
                customerDao.deleteCustomer(id);

                // Populate and return the response

                return createCustomerResponce;
            }
        } else {
            // Username does not exist in the AppUser table
            throw new CheckByUsername("The user with this email does not exist. Please sign up first.");
        }

    }
}
