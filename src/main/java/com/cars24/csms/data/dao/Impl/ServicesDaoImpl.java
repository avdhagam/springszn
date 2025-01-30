package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.ServicesDao;

import com.cars24.csms.data.entities.ServicesEntity;
import com.cars24.csms.data.repositories.ServicesRepository;
import com.cars24.csms.data.req.BaseServiceReq;
import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.GetServiceReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicesDaoImpl implements ServicesDao {
    //@Autowired
    private final ServicesRepository repo;
    @Override
    public int createService(CreateServiceReq createServiceReq) {
        ServicesEntity se = new ServicesEntity();
        se.setId(0);
        se.setName(createServiceReq.getName());
        se.setPrice(createServiceReq.getPrice());
        repo.save(se);
        log.info("[ServicesDao]", createServiceReq);
        return 0;
    }

    @Override
    public ServicesEntity getService(BaseServiceReq baseServiceReq) {
        log.info("[getServiceByName] DAO fetching service with name: {}", baseServiceReq.getName());

        // Use the repository to fetch the service
        return repo.findByName(baseServiceReq.getName()).orElse(null);
    }

    @Override
    public void deleteServiceById(int id) {
        log.info("[deleteServiceById] Deleting service with ID: {}", id);

        // Delete the service using the repository
        repo.deleteById(id);
    }

    @Override
    public void updateService(ServicesEntity servicesEntity) {
        log.info("[updateService] DAO updating service: {}", servicesEntity);
        repo.save(servicesEntity); // Save the updated entity
    }

}


