package com.cars24.csms.data.dao;

import com.cars24.csms.data.entity.ServicesEntity;
import com.cars24.csms.data.req.BaseServiceReq;
import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.GetServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface ServicesDao {
    int createService(CreateServiceReq createServiceReq);
    ServicesEntity getService(BaseServiceReq baseServiceReq);
    void deleteServiceById(int id);
    void updateService(ServicesEntity servicesEntity);

}
