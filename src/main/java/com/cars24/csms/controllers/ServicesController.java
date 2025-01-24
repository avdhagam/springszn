package com.cars24.csms.Controller;

import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.DeleteServiceReq;
import com.cars24.csms.data.req.GetServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.CreateServiceResponse;
import com.cars24.csms.data.resp.GetServiceRes;
import com.cars24.csms.service.VehicleServiceManagementService;
import com.cars24.csms.service.impl.VehicleServiceManagementServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
@Validated
@Slf4j

//@Service
public class ServicesController {

    // @Autowired
    private final VehicleServiceManagementServiceImpl vsi;
    //private static final Logger log= LoggerFactory.getLogger(ServicesController.class);
    //VehicleServiceManagementService s;

    @PostMapping
    public ResponseEntity<APIResponse> createService(@Valid @RequestBody CreateServiceReq createServiceReq) {
        log.info("[createService] Received request to create service: {}", createServiceReq);

        // Call the service layer to handle the request
        APIResponse response = vsi.createService(createServiceReq);

        // Return the APIResponse object directly
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }




    @GetMapping("/by-name")
    public ResponseEntity<GetServiceRes> getServiceByName(@Valid @RequestBody GetServiceReq getServiceReq) {
        log.info("[getService] Fetching service with name: {}", getServiceReq);
        GetServiceRes service = vsi.getService(getServiceReq); // Call service layer
        return ResponseEntity.ok().body(service);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteService(@Valid @RequestBody DeleteServiceReq deleteServiceReq) {
        log.info("[deleteService] Deleting service with name: {}", deleteServiceReq.getName());
        vsi.deleteService(deleteServiceReq); // Call service layer
        return ResponseEntity.ok("Service deleted successfully!");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateService(@Valid @RequestBody UpdateServiceReq updateServiceReq) {
        log.info("[updateService] Updating service: {}", updateServiceReq);

        // Call the service layer to perform the update
        vsi.updateService(updateServiceReq);

        // Respond to the client
        return ResponseEntity.ok("Service updated successfully");
    }





}
