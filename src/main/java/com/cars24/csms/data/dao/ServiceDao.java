package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.ServiceEntity;
import java.util.List;
import java.util.Optional;

public interface ServiceDao {
    ServiceEntity save(ServiceEntity service);
    Optional<ServiceEntity> findById(Long id);
    Optional<ServiceEntity> findByName(String name);
    List<ServiceEntity> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}
