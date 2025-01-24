package com.cars24.csms.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @Column(name = "customer_id", nullable = false)
    private Integer CustomerId;

//    public Integer getCustomerId() {
//        return CustomerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        CustomerId = customerId;
//    }
}
