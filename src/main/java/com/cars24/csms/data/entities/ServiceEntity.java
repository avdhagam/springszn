package com.cars24.csms.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "services")
public class ServiceEntity {
    @Id
    @Column(name = "service_id", nullable = false)
    private Integer ServiceId;

//    public Integer getServiceId() {
//        return ServiceId;
//    }
//
//    public void setServiceId(Integer serviceId) {
//        ServiceId = serviceId;
//    }
}
