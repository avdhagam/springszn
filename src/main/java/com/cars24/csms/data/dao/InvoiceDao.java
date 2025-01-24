package com.cars24.csms.data.dao;

import com.cars24.csms.data.repositories.InvoiceRepository;
import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.CreateInvoiceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceDao {

    public Integer createInvoice(CreateInvoiceRequest createInvoiceRequest);
    CreateInvoiceResponse getInvoiceByID(int id);
    List<CreateInvoiceResponse> getAllInvoices();
    void deleteInvoice(int id);
    boolean existsByAppointment(int app_id);
}
