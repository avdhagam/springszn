package com.cars24.csms.data.resp;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.entities.ServiceEntity;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.enums.AppointmentStatus;
import lombok.Data;

@Data
public class CreateAppointmentsResponse {
    private CustomerEntity customerId;
    private VehicleEntity vehicleId;
    private ServiceEntity serviceId;
    private String appointmentDate;
    private AppointmentStatus status;


}
