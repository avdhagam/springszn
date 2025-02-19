package com.cars24.csms.service.impl;

import com.cars24.csms.data.dao.Impl.InvoiceDaoImpl;
import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.CreateInvoiceResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceDaoImpl invoiceDao;

    @Override
    public ResponseEntity<APIResponse> createInvoice(CreateInvoiceRequest createInvoiceRequest) {
        APIResponse response = new APIResponse();

        if (invoiceDao.existsByAppointment(createInvoiceRequest.getAppointment_id())) {
            invoiceDao.createInvoice(createInvoiceRequest);
            response.setSuccess(true);
            response.setStatuscode(HttpStatus.CREATED.value());
            response.setMessage("Invoice created successfully");
            response.setService("INVOICE-SERVICE");
            response.setData(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            throw new UserServiceException("Appointment ID does not exist");
        }
    }

    @Override
    public ResponseEntity<APIResponse> getInvoiceByID(int id) {
        CreateInvoiceResponse invoice = invoiceDao.;
        APIResponse response = new APIResponse();

        if (invoice != null) {
            response.setSuccess(true);
            response.setStatuscode(HttpStatus.OK.value());
            response.setMessage("Invoice retrieved successfully");
            response.setService("INVUSR");
            response.setData(invoice);
            return ResponseEntity.ok(response);
        } else {
            throw new UserServiceException("Invoice not found");
        }
    }

    @Override
    public ResponseEntity<APIResponse> getAllInvoices() {
        List<CreateInvoiceResponse> invoices = invoiceDao.getAllInvoices();
        APIResponse response = new APIResponse();

        response.setSuccess(true);
        response.setStatuscode(HttpStatus.OK.value());
        response.setMessage("All invoices retrieved successfully");
        response.setService("INVUSR");
        response.setData(invoices);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<APIResponse> deleteInvoice(int id) {
        invoiceDao.deleteInvoice(id);
        APIResponse response = new APIResponse();

        response.setSuccess(true);
        response.setStatuscode(HttpStatus.OK.value());
        response.setMessage("Invoice deleted successfully");
        response.setService("INVUSR");
        response.setData(null);
        return ResponseEntity.ok(response);
    }
}
