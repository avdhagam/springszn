package com.cars24.csms.service;

import com.cars24.csms.data.req.CreateServiceRequest;
import com.cars24.csms.data.req.UpdateServiceRequest;
import com.cars24.csms.data.resp.APIResponse;
import org.springframework.http.ResponseEntity;

public interface ServiceManagementService {
    ResponseEntity<APIResponse> createService(CreateServiceRequest request);
    ResponseEntity<APIResponse> updateService(UpdateServiceRequest request);
    ResponseEntity<APIResponse> deleteService(Long id);
    ResponseEntity<APIResponse> getAllServices();
}
