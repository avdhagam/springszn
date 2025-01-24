package com.cars24.csms.controllers;

import com.cars24.csms.data.dao.VehicleDao;
import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.resp.CreateVehicleResp;
import com.cars24.csms.service.impl.VehicleServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles")
@Validated
@Slf4j

public class VehicleController {

    private final VehicleServiceImpl vehicleService;
    private final VehicleDao vehicleDao;

    @PostMapping
    public ResponseEntity<CreateVehicleResp> createVehicle(@Valid @RequestBody CreateVehicleReq createVehicleReq) {
        //System.out.println("[createVehicle] " + createVehicleReq);
        log.info("Create vehicle request: {}", createVehicleReq);
        CreateVehicleResp createVehicleResp = new CreateVehicleResp();

        vehicleService.createVehicle(createVehicleReq);
        return ResponseEntity.ok().body(createVehicleResp);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVehicle(@Valid @RequestBody CreateVehicleReq createVehicleReq, @PathVariable int id) {
        log.info("Update vehicle request: {}", createVehicleReq);
        vehicleService.updateVehicle(createVehicleReq, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateVehicleResp> getVehicle(@PathVariable int id) {
        log.info("Get vehicle request: {}", id);
        vehicleService.getVehicle(id);
        CreateVehicleResp createVehicleResp = vehicleDao.getVehicle(id);
        return ResponseEntity.ok().body(createVehicleResp);
    }

    @GetMapping("/all")
    public ResponseEntity<CreateVehicleResp> getAllVehicles() {
        log.info("Get all vehicles");
        CreateVehicleResp createVehicleResp = vehicleService.getAllVehicles();
        log.info("Get all vehicles response: {}", createVehicleResp);
        return ResponseEntity.ok().body(createVehicleResp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        log.info("Delete vehicle request: {}", id);
        return ResponseEntity.noContent().build();
    }
}