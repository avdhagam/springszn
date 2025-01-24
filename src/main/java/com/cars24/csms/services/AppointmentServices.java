package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.req.GetAppointmentsRequest;
import com.cars24.csms.data.req.UpdateAppointmentsRequest;
import com.cars24.csms.data.res.CreateAppointmentsResponse;
import com.cars24.csms.data.res.GetAppointmentsResponse;
import org.springframework.http.ResponseEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AppointmentServices {
    CreateAppointmentsResponse createAppointment(CreateAppointmentsRequest createAppointmentsRequest);
//    List<CreateAppointmentsResponse> getAppointments(CreateAppointmentsRequest createAppointmentsRequest);

    List<GetAppointmentsResponse> getAppointments(Integer customerId);

//    boolean deleteAppointments(Integer customerId);
//    void updateAppointment(int appointmentId, UpdateAppointmentsRequest updateAppointmentsRequest);
    void deleteAppointment(int appointmentId);
}
