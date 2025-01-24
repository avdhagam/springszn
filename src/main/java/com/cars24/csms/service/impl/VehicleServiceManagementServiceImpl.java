package com.cars24.csms.service.impl;


import com.cars24.csms.data.dao.Impl.ServicesDaoImpl;
import com.cars24.csms.data.entity.ServicesEntity;
import com.cars24.csms.data.repositories.ServicesRepository;
import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.DeleteServiceReq;
import com.cars24.csms.data.req.GetServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.CreateServiceResponse;
import com.cars24.csms.data.resp.GetServiceRes;
import com.cars24.csms.exceptions.ServiceAlreadyExistsException;
import com.cars24.csms.service.VehicleServiceManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleServiceManagementServiceImpl implements VehicleServiceManagementService {
    //@Autowired
    private final ServicesDaoImpl servicesDaoimpl;

    @Override
    public APIResponse createService(CreateServiceReq createServiceReq) {
        // Check if a service with the same name already exists
        GetServiceReq getServiceReq = new GetServiceReq();
        getServiceReq.setName(createServiceReq.getName());

        ServicesEntity existingService = servicesDaoimpl.getService(getServiceReq);

        if (existingService != null) {
            // If service already exists, throw custom exception
            throw new ServiceAlreadyExistsException("Service already exists with name: " + createServiceReq.getName());
        }

        // Create a new service if it doesn't exist
        servicesDaoimpl.createService(createServiceReq);

        // Prepare the response for successful creation
        CreateServiceResponse createServiceResponse = new CreateServiceResponse();
        createServiceResponse.setName(createServiceReq.getName());
        createServiceResponse.setPrice(createServiceReq.getPrice());

        // Wrap the response in APIResponse
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatusCode(201); // HTTP 201 Created
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Service created successfully");
        apiResponse.setData(createServiceResponse); // Embed the response object
        apiResponse.setService("SERVICE-CREATION");

        return apiResponse;
    }


    @Override
    public GetServiceRes getService(GetServiceReq getServiceReq) {
        // Log the action
        log.info("[getServiceByName] Fetching service with name: {}", getServiceReq.getName());

        // Extract the name from the request object
        String serviceName = getServiceReq.getName();

        // Call DAO to fetch the entity by name
        ServicesEntity entity = servicesDaoimpl.getService(getServiceReq);

        // Handle if no service is found
        if (entity == null) {
            throw new RuntimeException("Service not found with name: " + serviceName);
        }

        // Map the entity to the response object
        GetServiceRes response = new GetServiceRes();
        response.setName(entity.getName());
        response.setPrice(entity.getPrice());

        return response;
    }

    @Override
    public void deleteService(DeleteServiceReq deleteServiceReq) {
        log.info("[deleteService] Processing deletion for service name: {}", deleteServiceReq.getName());

        // Fetch the service entity by name from the DAO layer
        ServicesEntity entity = servicesDaoimpl.getService(deleteServiceReq);
        if (entity == null) {
            throw new RuntimeException("Service not found with name: " + deleteServiceReq.getName());
        }

        // Delete the entity using the DAO layer
        servicesDaoimpl.deleteServiceById(entity.getId());
    }

    @Override
    public void updateService(UpdateServiceReq updateServiceReq) {
        log.info("[updateService] Validating and updating service: {}", updateServiceReq);

        // Fetch the existing entity by current name via DA0
        GetServiceReq getServiceReq= new GetServiceReq();
        getServiceReq.setName(updateServiceReq.getCurrentName());
        ServicesEntity existingEntity = servicesDaoimpl.getService(getServiceReq);
        if (existingEntity == null) {
            throw new RuntimeException("Service not found with name: " + updateServiceReq.getCurrentName());
        }

        // Check if the updated name already exists via DAO
        GetServiceReq getServiceReq1= new GetServiceReq();
        getServiceReq1.setName(updateServiceReq.getUpdatedName());
        ServicesEntity existingEntityWithNewName = servicesDaoimpl.getService(getServiceReq1);
        if (existingEntityWithNewName != null &&
                !existingEntityWithNewName.getId().equals(existingEntity.getId())) {
            throw new RuntimeException("A service with the updated name already exists");
        }

        // Update fields conditionally
        if (updateServiceReq.getUpdatedName() != null) {
            existingEntity.setName(updateServiceReq.getUpdatedName()); // Update name if provided
        }
        if (updateServiceReq.getUpdatedPrice() != null) {
            existingEntity.setPrice(updateServiceReq.getUpdatedPrice()); // Update price if provided
        }

        // Save the updated entity using DAO
        servicesDaoimpl.updateService(existingEntity);

        log.info("[updateService] Service updated successfully: {}", updateServiceReq);
    }


}

