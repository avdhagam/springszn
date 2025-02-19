package com.cars24.csms.controllers;

import com.cars24.csms.data.req.CreateServiceRequest;
import com.cars24.csms.data.req.UpdateServiceRequest;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.service.ServiceManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceManagementService serviceManagementService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createService(@Valid @RequestBody CreateServiceRequest request) {
        return serviceManagementService.createService(request);
    }

    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateService(@Valid @RequestBody UpdateServiceRequest request) {
        return serviceManagementService.updateService(request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteService(@PathVariable Long id) {
        return serviceManagementService.deleteService(id);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllServices() {
        return serviceManagementService.getAllServices();
    }
}
