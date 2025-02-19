package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.resp.CreateVehicleResp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleDao {
    public int createVehicle(CreateVehicleReq createVehicleReq);
    public int updateVehicle(int id, CreateVehicleReq createVehicleReq);
    public int deleteVehicle(int id);
    public CreateVehicleResp getVehicle(int id);
    public List<VehicleEntity> getAllVehicles();
}
