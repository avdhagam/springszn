package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.ServiceType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
//import javax.validation.Valid;
//import javax.validation.constraints.*;

@Valid
@Data  //getter setter tostring
public class DeleteServiceReq extends BaseServiceReq{

}
