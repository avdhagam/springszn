package com.cars24.csms.data.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServiceResponse {
    private Long id;
    private String name;
    private Double price;
}
