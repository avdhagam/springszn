package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.InvoiceStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Data;

import javax.persistence.Column;


@Valid
@Data
public class CreateInvoiceRequest {
    @Valid
    @Min(value = 1,message = "invalid appointment id")
    private int appointment_id;

    @Valid
    @Min(value = 1,message = "invalid amount")
    private double amount;


    private InvoiceStatus status;

}
