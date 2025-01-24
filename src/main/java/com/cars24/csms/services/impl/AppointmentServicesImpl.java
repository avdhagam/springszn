package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.AppointmentsDaoImpl;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.entities.ServiceEntity;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.repositories.ServiceRepository;
import com.cars24.csms.data.repositories.VehicleRepository;
import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.req.GetAppointmentsRequest;
import com.cars24.csms.data.req.UpdateAppointmentsRequest;
import com.cars24.csms.data.res.CreateAppointmentsResponse;
import com.cars24.csms.data.res.GetAppointmentsResponse;
import com.cars24.csms.services.AppointmentServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentServicesImpl implements AppointmentServices {

//    @Autowired
    private final AppointmentsDaoImpl appointmentsDaoimpl;
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public CreateAppointmentsResponse createAppointment(CreateAppointmentsRequest createAppointmentsRequest) {
        log.info("[createAppointment] createAppointmentsRequest: ", createAppointmentsRequest);

        CustomerEntity customer = customerRepository.findById(createAppointmentsRequest.getCustomerId()).orElse(null);
        if (customer == null) {
            log.error("[createAppointment] Customer with ID {} not found", createAppointmentsRequest.getCustomerId());
            // Handle the error (e.g., throw an exception, return an error response, etc.)
            return null;
        }

        VehicleEntity vehicle = vehicleRepository.findById(createAppointmentsRequest.getVehicleId()).orElse(null);
        if (vehicle == null) {
            log.error("[createAppointment] Customer with ID {} not found", createAppointmentsRequest.getCustomerId());
            // Handle the error (e.g., throw an exception, return an error response, etc.)
            return null;
        }

        ServiceEntity service = serviceRepository.findById(createAppointmentsRequest.getServiceId()).orElse(null);
        if (service == null) {
            log.error("[createAppointment] Service with ID {} not found", createAppointmentsRequest.getServiceId());
            // Handle the error
            return null;
        }

        appointmentsDaoimpl.createAppointments(createAppointmentsRequest);
        return null;
    }

    @Override
    public List<GetAppointmentsResponse> getAppointments(Integer customerId) {
        return appointmentsDaoimpl.getAppointments(customerId);

//        ObjectMapper objectMapper = n
    }

//    @Override
//    public void updateAppointment(int appointmentId, UpdateAppointmentsRequest updateAppointmentsRequest) {
//        AppointmentsEntity existingAppointment = appointmentsDaoimpl.findById(appointmentId)
//                .orElseThrow(() -> new NoSuchElementException("Appointment with ID " + appointmentId + " does not exist."));
//
//        //Update only allowed fields
//        if(updateAppointmentsRequest.getAppointmentDate() != null){
//            existingAppointment.setAppointmentDate(updateAppointmentsRequest.getAppointmentDate());
//        }
//        if(updateAppointmentsRequest.getStatus() != null){
//            existingAppointment.setStatus(updateAppointmentsRequest.getStatus());
//        }
//
//
//        appointmentsDaoimpl.save(existingAppointment);
//    }

    @Override
    public void deleteAppointment(int appointmentId) {
        if(!appointmentsDaoimpl.existsById(appointmentId)){
            throw new NoSuchElementException("Appointment with ID " + appointmentId + " doesnt exist");
        }
        appointmentsDaoimpl.deleteAppointment(appointmentId);
    }

//    @Override
//    public boolean deleteAppointments(Integer customerId) {
//        if(customerId > 0){
//            return true;
//        }
//        return false;
//    }
}
