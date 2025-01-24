package com.cars24.csms.data.res;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.entities.ServiceEntity;
import com.cars24.csms.data.entities.VehicleEntity;
import lombok.Data;

@Data
public class GetAppointmentsResponse {
    private CustomerEntity customerId;
    private VehicleEntity vehicleId;
    private ServiceEntity serviceId;
    private String appointmentDate;
    private String status;

    public CustomerEntity getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerEntity customerId) {
        this.customerId = customerId;
    }

    public VehicleEntity getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(VehicleEntity vehicleId) {
        this.vehicleId = vehicleId;
    }

    public ServiceEntity getServiceId() {
        return serviceId;
    }

    public void setServiceId(ServiceEntity serviceId) {
        this.serviceId = serviceId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
