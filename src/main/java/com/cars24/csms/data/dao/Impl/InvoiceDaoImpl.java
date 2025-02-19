package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.InvoiceDao;
import com.cars24.csms.data.entities.InvoiceEntity;
import com.cars24.csms.data.enums.InvoiceStatus;
import com.cars24.csms.data.repositories.InvoiceRepository;
import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.CreateInvoiceResponse;
import com.cars24.csms.exceptions.UserServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceDaoImpl implements InvoiceDao {

    private final InvoiceRepository invoiceRepository ;

    @Override
    public Integer createInvoice(CreateInvoiceRequest createInvoiceRequest){
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setStatus(createInvoiceRequest.getStatus().toString());
        invoiceEntity.setAppid(createInvoiceRequest.getAppointment_id());
        invoiceEntity.setAmount(createInvoiceRequest.getAmount());
        invoiceRepository.save(invoiceEntity);

        return 0;
    }
    @Override
    public CreateInvoiceResponse getInvoiceByID(int id){
        log.info("fetching invoice by id {}",id);
        InvoiceEntity invoiceEntity = invoiceRepository.findById(id)
                .orElseThrow(()-> new UserServiceException("gyy"));


        return mapEntityToResponse(invoiceEntity);
    }


    @Override
    public List<CreateInvoiceResponse> getAllInvoices() {
        log.info("Fetching all invoices");
        List<InvoiceEntity> invoiceEntities = invoiceRepository.findAll();
        return invoiceEntities.stream()
                .map(this::mapEntityToResponse)
                .toList();
    }

    private CreateInvoiceResponse mapEntityToResponse(InvoiceEntity invoiceEntity){
        CreateInvoiceResponse createInvoiceResponse = new CreateInvoiceResponse();
        createInvoiceResponse.setAmount(invoiceEntity.getAmount());
        createInvoiceResponse.setStatus(InvoiceStatus.valueOf(invoiceEntity.getStatus()));
        createInvoiceResponse.setAppointment_id(invoiceEntity.getAppid());


        return createInvoiceResponse;
    }

    public void deleteInvoice(int id){
        log.info("delete invoice with id {}",id);
        InvoiceEntity invoiceEntity = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with ID: " + id));
        invoiceEntity.setIs_active(false);
        invoiceRepository.save(invoiceEntity);
    }

    public boolean existsByAppointment(int appointment_id){
        return invoiceRepository.existsInvoiceEntityByAppid(appointment_id);
    }

}