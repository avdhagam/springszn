package com.cars24.csms.service.impl;

import com.cars24.csms.data.dao.VehicleDao;
import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.resp.CreateVehicleResp;
import com.cars24.csms.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    //@Autowired
    private final VehicleDao vehicleDao;


    @Override
    public CreateVehicleResp createVehicle(CreateVehicleReq createVehicleReq) {
        vehicleDao.createVehicle(createVehicleReq);
        return null;
    }

    @Override
    public CreateVehicleResp updateVehicle(CreateVehicleReq createVehicleReq, int id) {
        vehicleDao.updateVehicle(id, createVehicleReq);
        return null;
    }


    @Override
    public CreateVehicleResp getVehicle(int vehicleId) {
        vehicleDao.getVehicle(vehicleId);
        return null;
    }


    @Override
    public CreateVehicleResp deleteVehicle(int vehicleId) {
        vehicleDao.deleteVehicle(vehicleId);
        return null;
    }

    @Override
    public CreateVehicleResp getAllVehicles() {
        vehicleDao.getAllVehicles();
        return null;
    }
}
