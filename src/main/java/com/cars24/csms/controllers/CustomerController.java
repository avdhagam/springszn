package com.cars24.csms.controllers;
import com.cars24.csms.data.req.CreateAppointmentsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@Validated
@Slf4j
public class CustomerController {

    @GetMapping("/profile")
    public String getCustomer(CreateAppointmentsRequest createAppointmentsRequest){
        return null;
    }
}
