package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.resp.GetAppointmentsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentsRepository extends JpaRepository<AppointmentsEntity,Integer> {
//    existsByAppointment_Id
//    GetAppointmentsResponse findByCustomerIdAndServiceIdAndVehicleId(Integer customerId, Integer serviceId, Integer vehicleId);
    //custom query to use 3 fields to recognize an appointment
//    List<AppointmentsEntity> findByCustomerId(Integer customerId);
//    @Query("SELECT a FROM AppointmentsEntity a WHERE a.customerId.customerId = :customerId")
//    List<AppointmentsEntity> findByCustomerId(@Param("customerId") int customerId);
}
