package com.cars24.csms.service.impl;

import com.cars24.csms.data.dao.Impl.InvoiceDaoImpl;
import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.CreateInvoiceResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceDaoImpl invoiceDao;

    @Override
    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest createInvoiceRequest){
   if(invoiceDao.existsByAppointment(createInvoiceRequest.getAppointment_id())) {
       invoiceDao.createInvoice(createInvoiceRequest);
       return null;
   }
   else {
       throw new UserServiceException("application id doesn't exist");
   }
    }

    @Override
    public CreateInvoiceResponse getInvoiceByID(int id){
        return invoiceDao.getInvoiceByID(id);
    }

    @Override
    public List<CreateInvoiceResponse> getAllInvoices() {return invoiceDao.getAllInvoices();}

    @Override
    public void deleteInvoice(int id) {
        invoiceDao.deleteInvoice(id);
    }
}
