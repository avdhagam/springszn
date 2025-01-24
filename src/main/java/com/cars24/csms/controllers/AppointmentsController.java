package com.cars24.csms.controllers;

import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.req.GetAppointmentsRequest;
import com.cars24.csms.data.req.UpdateAppointmentsRequest;
import com.cars24.csms.data.res.CreateAppointmentsResponse;
import com.cars24.csms.data.res.GetAppointmentsResponse;
import com.cars24.csms.services.impl.AppointmentServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
@Validated // Class-level validation for method parameters (optional if unused)
@Slf4j
public class AppointmentsController {

//    private static final Logger log = LoggerFactory.getLogger(AppointmentsController.class);

    private final AppointmentServicesImpl appointmentServicesImpl;

    @PostMapping
    public ResponseEntity<CreateAppointmentsResponse> createAppointment(
            @Valid @RequestBody CreateAppointmentsRequest createAppointmentsRequest) {
        log.info("[createAppointments] Received request: {}", createAppointmentsRequest);

        // Replace this with your service method call logic
        CreateAppointmentsResponse createAppointmentsResponse = new CreateAppointmentsResponse();
        appointmentServicesImpl.createAppointment(createAppointmentsRequest);

        return ResponseEntity.ok().body(createAppointmentsResponse);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getAppointments(@PathVariable Integer customerId){
        log.info("Fetching appointments for customer ID: {}", customerId);
        try{
            List<GetAppointmentsResponse> appointments = appointmentServicesImpl.getAppointments(customerId);

            //if no appointments are found, return a custom message
            if(appointments.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK)
                        .body(Collections.singletonMap("message", "No appointments found for the customer id: " + customerId));
            }
            return ResponseEntity.ok(appointments);
        } catch (IllegalArgumentException e){
            log.error("[getAppointments] Invalid customer ID: {}", customerId, e);
            return ResponseEntity.badRequest()
                    .body(Collections.singletonMap("message", "Invalid customer id"));
        }catch (Exception e){
            log.error("[getAppointments] Unexpected Error: {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "An unexpected error occurred"));
        }
    }

//    @DeleteMapping("/{customerId}")
//    public ResponseEntity<?> deleteAppointments(@PathVariable Integer customerId){
//        log.info("Attempting to delete appointments for customer ID: {}",customerId);
//
//        try{
//            boolean isDeleted = appointmentServicesImpl.deleteAppointments(customerId);
//
//            if(isDeleted){
//                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//            } else{
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body(Collections.singletonMap("message","No appointments found for the customer ID: " + customerId));
//            }
//        } catch (Exception e){
//            log.error("[deleteAppointments] Unexpected Error: {}", e.getMessage(), e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(Collections.singletonMap("message", "An unexpected error occured sed"));
//        }
//    }


//    @PutMapping("/{appointmentId}")
//    public ResponseEntity<String> updateAppointment(
//            @PathVariable int appointmentId,
//            @RequestBody UpdateAppointmentsRequest updateAppointmentsRequest
//            ){
//        try{
//            appointmentServicesImpl.updateAppointment(appointmentId, updateAppointmentsRequest);
//            return ResponseEntity.ok("Appointment with ID "+ appointmentId + " has been updated successfully");
//        } catch (NoSuchElementException ex){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment with ID "+ appointmentId + " not found");
//        } catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured while updating the appointment");
//        }
//    }

    @DeleteMapping("/delete/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int appointmentId){
        try{
            appointmentServicesImpl.deleteAppointment(appointmentId);
            return ResponseEntity.ok("Appointment with ID " + appointmentId + " has been deleted successfully (marked inactive)");
        } catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment with ID " + appointmentId + " not found.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting the appointment.");
        }
    }
}
