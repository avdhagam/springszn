package com.cars24.csms.data.req;
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.entities.ServiceEntity;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.enums.AppointmentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

//import javax.validation.Valid;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Pattern;


@Valid
@Data //to string, getter, setter everything it will only do
public class CreateAppointmentsRequest {

    @Valid
    @Min(value = 1, message = "Invalid Customer ID")
//    private CustomerEntity customerId;
    private int customerId;

    @Valid
    @Min(value = 1, message = "Invalid Vehicle ID")
//    private VehicleEntity vehicleId;
    private int vehicleId;

    @Valid
    @Min(value = 1, message = "Invalid Service ID")
//    private ServiceEntity serviceId;
    private int serviceId;

    @Valid
    @NotBlank
    @Pattern(
            regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",
            message = "Invalid date format. Expected format: yyyy-MM-dd"
    )
    private String appointmentDate;

    @Valid
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    //to string overriding

//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public int getVehicleId() {
//        return vehicleId;
//    }
//
//    public void setVehicleId(int vehicleId) {
//        this.vehicleId = vehicleId;
//    }
//
//    public int getServiceId() {
//        return serviceId;
//    }
//
//    public void setServiceId(int serviceId) {
//        this.serviceId = serviceId;
//    }
//
//    public String getAppointmentDate() {
//        return appointmentDate;
//    }
//
//    public void setAppointmentDate(String appointmentDate) {
//        this.appointmentDate = appointmentDate;
//    }
//
//    public AppointmentStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(AppointmentStatus status) {
//        this.status = status;
//    }

//    @Override
//    public String toString() {
//        return "CreateAppointmentsRequest{" +
//                "customerId=" + customerId +
//                ", vehicleId=" + vehicleId +
//                ", serviceId=" + serviceId +
//                ", appointmentDate='" + appointmentDate + '\'' +
//                ", status=" + status +
//                '}';
//    }
}
