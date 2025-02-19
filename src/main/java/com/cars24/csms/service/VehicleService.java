package com.cars24.csms.service;

import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.resp.CreateVehicleResp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    CreateVehicleResp createVehicle(CreateVehicleReq createVehicleReq);
    CreateVehicleResp updateVehicle(CreateVehicleReq createVehicleReq, int id);
    CreateVehicleResp getVehicle(int vehicleId);
    public CreateVehicleResp deleteVehicle(int vehicleId);
    public List<VehicleEntity> getAllVehicles();
}
