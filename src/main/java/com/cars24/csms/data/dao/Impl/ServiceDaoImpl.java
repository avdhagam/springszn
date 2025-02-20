package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.ServiceDao;
import com.cars24.csms.data.entities.ServiceEntity;
import com.cars24.csms.data.repositories.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ServiceDaoImpl implements ServiceDao {

    private final ServiceRepository serviceRepository;

    @Override
    public ServiceEntity save(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    @Override
    public Optional<ServiceEntity> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public Optional<ServiceEntity> findByName(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public List<ServiceEntity> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return serviceRepository.existsById(id);
    }
}
