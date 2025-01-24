package com.cars24.csms.controllers;

import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.CreateInvoiceResponse;
import com.cars24.csms.service.InvoiceService;
import com.cars24.csms.service.impl.InvoiceServiceImpl;
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
    private final InvoiceServiceImpl invoiceService;

    @PostMapping
    public ResponseEntity<CreateInvoiceResponse> createInvoice(@Valid @RequestBody CreateInvoiceRequest createInvoiceRequest){
        // now we send it to the service
//        System.out.println("[createInvoice] createInvoiceRequest {}"+createInvoiceRequest);
        CreateInvoiceResponse createInvoiceResponse =  new CreateInvoiceResponse();
        log.info("[createInvoice] createInvoiceRequest {}",createInvoiceRequest);
        invoiceService.createInvoice(createInvoiceRequest);
//        return ResponseEntity.ok(createInvoiceResponse);
        return ResponseEntity.ok().body(createInvoiceResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateInvoiceResponse> getInvoiceByID(@PathVariable int id){
        log.info("fetching invoices with id {}",id);
        CreateInvoiceResponse createInvoiceResponse = invoiceService.getInvoiceByID(id);
        return ResponseEntity.ok().body(createInvoiceResponse);
    }

    @GetMapping
    public ResponseEntity<List<CreateInvoiceResponse>> getAllInvoices(){
        log.info("fetching all invoices");
        List<CreateInvoiceResponse> createInvoiceResponse = invoiceService.getAllInvoices();
        return ResponseEntity.ok().body(createInvoiceResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable int id){
        log.info("Deleting invoices with the id {}",id);
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok("Invoice deleted");
    }
}
