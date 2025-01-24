package com.cars24.csms.data.resp;

import com.cars24.csms.data.enums.ServiceType;
import lombok.Data;


@Data
public class GetServiceRes {

    private String name;

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CreateServiceResponse{" +
                "name=" + name +
                ", price=" + price +
                '}';
    }
}
