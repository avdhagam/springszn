package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {
    boolean existsInvoiceEntityByAppid(int appid);
}