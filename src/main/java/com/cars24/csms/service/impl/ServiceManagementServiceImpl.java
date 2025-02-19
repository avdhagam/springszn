package com.cars24.csms.service.impl;

import com.cars24.csms.data.dao.ServiceDao;
import com.cars24.csms.data.entities.ServiceEntity;
import com.cars24.csms.data.req.CreateServiceRequest;
import com.cars24.csms.data.req.UpdateServiceRequest;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.exceptions.ServiceAlreadyExistsException;
import com.cars24.csms.exceptions.ServiceNotFoundException;
import com.cars24.csms.service.ServiceManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceManagementServiceImpl implements ServiceManagementService {

    private final ServiceDao serviceDao;

    @Override
    public ResponseEntity<APIResponse> createService(CreateServiceRequest request) {
        log.info("[createService] - Creating service: {}", request.getName());

        if (serviceDao.findByName(request.getName()).isPresent()) {
            throw new ServiceAlreadyExistsException("Service already exists with this name");
        }

        ServiceEntity service = new ServiceEntity();
        service.setName(request.getName());
        service.setPrice(request.getPrice());
        serviceDao.save(service);

        return ResponseEntity.ok(new APIResponse(true, 201, "Service created successfully", "SERVICE", service));
    }

    @Override
    public ResponseEntity<APIResponse> updateService(UpdateServiceRequest request) {
        log.info("[updateService] - Updating service with ID: {}", request.getId());

        ServiceEntity service = serviceDao.findById(request.getId())
                .orElseThrow(() -> new ServiceNotFoundException("Service not found"));

        service.setName(request.getName());
        service.setPrice(request.getPrice());
        serviceDao.save(service);

        return ResponseEntity.ok(new APIResponse(true, 200, "Service updated successfully", "SERVICE", service));
    }

    @Override
    public ResponseEntity<APIResponse> deleteService(Long id) {
        log.info("[deleteService] - Deleting service with ID: {}", id);

        if (!serviceDao.existsById(id)) {
            throw new ServiceNotFoundException("Service not found");
        }
        serviceDao.deleteById(id);

        return ResponseEntity.ok(new APIResponse(true, 200, "Service deleted successfully", "SERVICE", null));
    }

    @Override
    public ResponseEntity<APIResponse> getAllServices() {
        log.info("[getAllServices] - Fetching all services");

        List<ServiceEntity> services = serviceDao.findAll();
        return ResponseEntity.ok(new APIResponse(true, 200, "All services retrieved", "SERVICE", services));
    }
}
