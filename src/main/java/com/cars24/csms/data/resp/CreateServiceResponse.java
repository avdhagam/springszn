package com.cars24.csms.data.resp;

import com.cars24.csms.data.enums.ServiceType;
import lombok.Data;


@Data
public class CreateServiceResponse {

    private String name;

    private double price;

}
