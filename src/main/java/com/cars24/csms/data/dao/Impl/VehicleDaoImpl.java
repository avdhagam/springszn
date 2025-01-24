package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.VehicleDao;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.repositories.VehicleRepository;
import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.resp.CreateVehicleResp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

    public class VehicleDaoImpl implements VehicleDao{

        private final VehicleRepository vehicleRepository;


        public int createVehicle(CreateVehicleReq createVehicleReq) {
            VehicleEntity vehicleEntity = new VehicleEntity();

            vehicleEntity.setVehicle_id(createVehicleReq.getVehicle_id());
            vehicleEntity.setCustomer_id(createVehicleReq.getCustomer_id());
            vehicleEntity.setMake(createVehicleReq.getMake());
            vehicleEntity.setLicense_plate(createVehicleReq.getLicense_plate());
            vehicleEntity.setModel(createVehicleReq.getModel());
            vehicleEntity.setYear(createVehicleReq.getYear());
            vehicleEntity.setColor(createVehicleReq.getColor());
            vehicleRepository.save(vehicleEntity);
            return 0;
        }

    @Override
    public int updateVehicle(int id, CreateVehicleReq createVehicleReq) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id).orElse(null);
        vehicleEntity.setCustomer_id(createVehicleReq.getCustomer_id());
        vehicleEntity.setMake(createVehicleReq.getMake());
        vehicleEntity.setLicense_plate(createVehicleReq.getLicense_plate());
        vehicleEntity.setModel(createVehicleReq.getModel());
        vehicleEntity.setYear(createVehicleReq.getYear());
        vehicleEntity.setColor(createVehicleReq.getColor());
        vehicleRepository.save(vehicleEntity);
        return 0;
    }

    @Override
    public int deleteVehicle(int id) {
            VehicleEntity vehicleEntity = vehicleRepository.findById(id).orElse(null);
            vehicleRepository.delete(vehicleEntity);
        return 0;
    }

    @Override
    public CreateVehicleResp getVehicle(int id) {
            VehicleEntity vehicleEntity = vehicleRepository.findById(id).orElse(null);
            CreateVehicleResp createVehicleResp = new CreateVehicleResp();
            createVehicleResp.setVehicle_id(vehicleEntity.getVehicle_id());
            createVehicleResp.setCustomer_id(vehicleEntity.getCustomer_id());
            createVehicleResp.setMake(vehicleEntity.getMake());
            createVehicleResp.setLicense_plate(vehicleEntity.getLicense_plate());
            createVehicleResp.setModel(vehicleEntity.getModel());
            createVehicleResp.setColor(vehicleEntity.getColor());
            createVehicleResp.setYear(vehicleEntity.getYear());
            log.info("vehicleEntity: {}", vehicleEntity);
        return createVehicleResp;
    }

    @Override
    public List<VehicleEntity> getAllVehicles() {
            List<VehicleEntity> vehicleEntities = vehicleRepository.findAll();
        return vehicleEntities;
    }

}

