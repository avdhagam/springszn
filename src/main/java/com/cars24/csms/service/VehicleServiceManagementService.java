package com.cars24.csms.service;

import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.DeleteServiceReq;
import com.cars24.csms.data.req.GetServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.CreateServiceResponse;
import com.cars24.csms.data.resp.GetServiceRes;
import org.springframework.stereotype.Service;

@Service
public interface VehicleServiceManagementService {
    APIResponse createService(CreateServiceReq createServiceReq);
    GetServiceRes getService(GetServiceReq getServiceReq);
    void deleteService(DeleteServiceReq deleteServiceReq);
    public void updateService(UpdateServiceReq updateServiceReq);

}
