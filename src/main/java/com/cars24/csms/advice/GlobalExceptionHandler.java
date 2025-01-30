package com.cars24.csms.advice;


import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.exceptions.ServiceAlreadyExistsException;
import com.cars24.csms.exceptions.UserServiceException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



    //    @ExceptionHandler(ValidationException.class)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
        log.info("[handleValidationExceptions]");

        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });

        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("invalid data");
        apiResponse.setService("APPUSR-"+HttpStatus.OK.value());
        apiResponse.setData(errorMap);
        return ResponseEntity.badRequest().body(apiResponse);
//        return errorMap;
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<APIResponse> handleUserServiceExceptions(UserServiceException exception)
    {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("APPUSR-"+HttpStatus.OK.value());
        apiResponse.setData(null);
        return ResponseEntity.badRequest().body(apiResponse);
//        return errorMap;
    }

    @ExceptionHandler(ServiceAlreadyExistsException.class)
    public ResponseEntity<APIResponse> handleServiceAlreadyExistsException(ServiceAlreadyExistsException ex) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatusCode(HttpStatus.CONFLICT.value()); // HTTP 409 Conflict
        apiResponse.setSuccess(false);
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setData(null); // No additional data for this error
        apiResponse.setService("SERVICE-CREATION");

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }


}
