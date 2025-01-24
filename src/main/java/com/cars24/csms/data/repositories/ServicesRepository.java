package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entity.ServicesEntity;
import com.cars24.csms.data.req.GetServiceReq;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ServicesRepository extends JpaRepository<ServicesEntity,Integer> {
    Optional<ServicesEntity> findByName(String name);
    //@Query("SELECT s FROM ServicesEntity s WHERE s.name = :name AND s.price = :price")
    //Optional<ServicesEntity> findByNameAndPrice(@Param("name") String name, @Param("price") double price);

}