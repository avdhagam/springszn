package com.cars24.csms.service;

import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {
    ResponseEntity<APIResponse> createInvoice(CreateInvoiceRequest createInvoiceRequest);
    ResponseEntity<APIResponse> getInvoiceByID(int id);
    ResponseEntity<APIResponse> getAllInvoices();
    ResponseEntity<APIResponse> deleteInvoice(int id);
}
