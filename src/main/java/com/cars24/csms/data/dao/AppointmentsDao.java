package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.req.GetAppointmentsRequest;
import com.cars24.csms.data.resp.GetAppointmentsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentsDao {
    Integer createAppointments(CreateAppointmentsRequest createAppointmentsRequest);
    List<GetAppointmentsResponse> getAppointments(Integer customerId);
    Optional<AppointmentsEntity> findById(int appointmentId);
    boolean deleteAppointment(Integer appointmentId);
    boolean existsById(int appointmentId);
    void save(AppointmentsEntity appointmentsEntity);
//    AppointmentsEntity updateAppointment();
}
