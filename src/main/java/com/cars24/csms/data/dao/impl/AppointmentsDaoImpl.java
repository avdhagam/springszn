package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppointmentsDao;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.entities.ServiceEntity;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.enums.AppointmentStatus;
import com.cars24.csms.data.repositories.AppointmentsRepository;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.repositories.ServiceRepository;
import com.cars24.csms.data.repositories.VehicleRepository;
import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.req.GetAppointmentsRequest;
import com.cars24.csms.data.res.CreateAppointmentsResponse;
import com.cars24.csms.data.res.GetAppointmentsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentsDaoImpl implements AppointmentsDao {

    private final AppointmentsRepository appointmentsRepository;
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public Integer createAppointments(CreateAppointmentsRequest createAppointmentsRequest) {

        // Fetch the customer, vehicle, and service entities
        CustomerEntity customer = customerRepository.findById(createAppointmentsRequest.getCustomerId()).orElse(null);
        if (customer == null) {
            log.error("[createAppointments] Customer with ID {} not found", createAppointmentsRequest.getCustomerId());
            return -1;  // Return error code if not found
        }

        VehicleEntity vehicle = vehicleRepository.findById(createAppointmentsRequest.getVehicleId()).orElse(null);
        if (vehicle == null) {
            log.error("[createAppointments] Vehicle with ID {} not found", createAppointmentsRequest.getVehicleId());
            return -1;  // Return error code if not found
        }

        ServiceEntity service = serviceRepository.findById(createAppointmentsRequest.getServiceId()).orElse(null);
        if (service == null) {
            log.error("[createAppointments] Service with ID {} not found", createAppointmentsRequest.getServiceId());
            return -1;  // Return error code if not found
        }

        // Create the appointment entity and set the values
        AppointmentsEntity appointmentsEntity = new AppointmentsEntity();

        appointmentsEntity.setAppointmentId(0);
        // The appointment ID is autogenerated by the database, so we don't need to set it manually.
        appointmentsEntity.setCustomerId(customer);  // Set CustomerEntity
        appointmentsEntity.setVehicleId(vehicle);    // Set VehicleEntity
        appointmentsEntity.setServiceId(service);    // Set ServiceEntity
        appointmentsEntity.setAppointmentDate(createAppointmentsRequest.getAppointmentDate());
        appointmentsEntity.setStatus(AppointmentStatus.valueOf(String.valueOf(createAppointmentsRequest.getStatus())));
        appointmentsEntity.setActive(true);
        // Save the appointment entity
        appointmentsEntity = appointmentsRepository.save(appointmentsEntity); // Save and fetch the saved entity

        // Return the generated appointment ID
        return appointmentsEntity.getAppointmentId();  // Return the generated appointment ID
    }

    @Override
    public List<GetAppointmentsResponse> getAppointments(Integer customerId) {
        log.info("[getAppointments] Fetching appointments for customer ID: {}", customerId);
//
//        List<AppointmentsEntity> appointmentsEntityList = appointmentsRepository.findAll()
//                .stream()
//                .filter(appointment -> appointment.getCustomerId().equals(getAppointmentsRequest.getCustomerId()))
//                .toList();
//
//        return appointmentsEntityList.stream()
//                .map(appointment -> {
//                    String formattedDate = appointment.getAppointmentDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//
//                    AppointmentStatus status = AppointmentStatus.valueOf(appointment.getStatus());
//
//                    GetAppointmentsResponse getAppointmentsResponse = new GetAppointmentsResponse();
//                    getAppointmentsResponse.setCustomerId(appointment.getCustomerId().getCustomerId());;
////                    return new GetAppointmentsResponse(
////                            appointment.getAppointmentId(),
////                            appointment.getCustomerId(),
////                            appointment.getVehicleId(),
////                            appointment.getServiceId(),
////                            formattedDate,
////                            status
////                    );
//                });

        // Fetch appointments for the given customerId
        List<AppointmentsEntity> appointmentsEntities = appointmentsRepository.findAll()
                .stream()
                .filter(appointment -> appointment.getCustomerId().getCustomerId().equals(customerId))
                .toList();

        if (appointmentsEntities.isEmpty()) {
            log.error("[getAppointments] No appointments found for customer ID: {}", customerId);
            return null;  // You can return an empty list or null, depending on how you want to handle no results
        }

        // Map the list of AppointmentsEntity to GetAppointmentsResponse
        return appointmentsEntities.stream()
                .map(appointmentsEntity -> {
                    GetAppointmentsResponse response = new GetAppointmentsResponse();

                    // Map the properties from AppointmentsEntity to GetAppointmentsResponse
//                    response.setAppointmentId(appointmentsEntity.getAppointmentId());
                    response.setCustomerId(appointmentsEntity.getCustomerId());  // Assuming CustomerEntity has customerId field
                    response.setVehicleId(appointmentsEntity.getVehicleId());      // Assuming VehicleEntity has vehicleId field
                    response.setServiceId(appointmentsEntity.getServiceId());      // Assuming ServiceEntity has serviceId field
                    response.setAppointmentDate(appointmentsEntity.getAppointmentDate());
                    response.setStatus(appointmentsEntity.getStatus().toString());

                    return response;
                })
                .collect(Collectors.toList());

    }

    @Override
    public Optional<AppointmentsEntity> findById(int appointmentId) {
        return appointmentsRepository.findById(appointmentId);
    }

    @Override
    public boolean deleteAppointment(Integer appointmentId) {
        // Fetch the appointment by appointmentId
        Optional<AppointmentsEntity> optionalAppointment = appointmentsRepository.findById(appointmentId);

        if (!optionalAppointment.isPresent()) {
            log.error("[deleteAppointment] Appointment with ID {} not found", appointmentId);
            return false;
        }

        AppointmentsEntity appointment = optionalAppointment.get();

        // Check if the appointment is already inactive, to prevent unnecessary updates
        if (!appointment.isActive()) {
            log.info("[deleteAppointment] Appointment with ID {} is already deactivated", appointmentId);
            return false;
        }

        // Set the active status to false (soft delete)
        appointment.setActive(false);

        // Save the updated appointment back to the database
        appointmentsRepository.save(appointment);

        log.info("[deleteAppointment] Successfully deactivated appointment with ID: {}", appointmentId);
        return true;
    }

    @Override
    public boolean existsById(int appointmentId) {
        return false;
    }

    @Override
    public void save(AppointmentsEntity appointmentsEntity) {
        appointmentsRepository.save(appointmentsEntity);
    }

//    @Override
//    public AppointmentsEntity updateAppointment() {
//        return null;
//    }
}
