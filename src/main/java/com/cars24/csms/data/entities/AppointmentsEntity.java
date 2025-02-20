package com.cars24.csms.data.entities;

import com.cars24.csms.data.enums.AppointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
//import jakarta.persistence.Column;

@Data
@Entity
@Table(name = "appointments")
public class AppointmentsEntity {

    @Id //cuz appointmentId is the primary key
    //all the constraints can be put here itself and if it doesnt exist spring constructs the tbale on its own
//    @jakarta.persistence.Id
    @Column(name = "appointment_id", nullable = false) //incase you want to specify a different name in the db
    private Integer appointmentId;

//    @Column(name = "customer_id",nullable = false)
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id",nullable = false)
    private VehicleEntity vehicleId;

    @ManyToOne
    @JoinColumn(name = "service_id",nullable = false)
    private ServiceEntity serviceId;

    @Column(name = "appointment_date",nullable = false)
    private String appointmentDate;

    @Column(name = "status",length = 50)
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Column(name = "active")
    private boolean active;

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    //    public void setAppointmentDate(@Valid @NotBlank @Pattern(
//            regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",
//            message = "Invalid date format. Expected format: yyyy-MM-dd"
//    ) String appointmentDate) {
//        this.appointmentDate = appointmentDate;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }


    @Override
    public String toString() {
        return "AppointmentsEntity{" +
                "appointmentId=" + appointmentId +
                ", customerId=" + customerId +
                ", vehicleId=" + vehicleId +
                ", serviceId=" + serviceId +
                ", appointmentDate=" + appointmentDate +
                ", status='" + status + '\'' +
                ", active=" + active + '\'' +
                '}';
    }


}
