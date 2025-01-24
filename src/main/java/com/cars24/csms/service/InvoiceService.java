package com.cars24.csms.service;

import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.CreateInvoiceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {
    CreateInvoiceResponse createInvoice(CreateInvoiceRequest createInvoiceRequest);
    CreateInvoiceResponse getInvoiceByID(int id);
    List<CreateInvoiceResponse> getAllInvoices();
    void deleteInvoice(int id);
    //delete

}
