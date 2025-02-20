
package com.cars24.csms.controllers;

import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.service.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/invoice")
@Validated
@Slf4j
public class InvoiceController {
    private final InvoiceService invoiceService;
    //

    @PostMapping
    public ResponseEntity<APIResponse> createInvoice(@Valid @RequestBody CreateInvoiceRequest createInvoiceRequest) {
        log.info("[createInvoice] createInvoiceRequest {}", createInvoiceRequest);
        // now we send it to the service

        return invoiceService.createInvoice(createInvoiceRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getInvoiceByID(@PathVariable int id) {
        log.info("Fetching invoice with id {}", id);
        return invoiceService.getInvoiceByID(id);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllInvoices() {
        log.info("Fetching all invoices");
        return invoiceService.getAllInvoices();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteInvoice(@PathVariable int id) {
        log.info("Deleting invoice with id {}", id);
        return invoiceService.deleteInvoice(id);
    }
}
