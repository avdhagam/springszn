package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class UpdateAppointmentsRequest {
    @Valid
    @NotBlank
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2}",
            message = "Invalid date-time format. Expected format: yyyy-MM-dd"
    )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime appointmentDate;

    private AppointmentStatus status;

    public String getAppointmentDate() {
        if (appointmentDate != null) {
            // Return the formatted date as a string
            return appointmentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return null;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
