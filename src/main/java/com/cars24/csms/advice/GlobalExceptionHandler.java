package com.cars24.csms.advice;


import com.cars24.csms.data.resp.APIResp;
//import com.cars24.demo.exceptions.ServiceAlreadyExistsException;
import com.cars24.csms.exceptions.UserServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



    //    @ExceptionHandler(ValidationException.class)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResp()> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
        log.info("[handleValidationExceptions]");

        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });

        APIResp apiResponse = new APIResp();
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("invalid data");
        apiResponse.setService("APPUSR-"+HttpStatus.OK.value());
        apiResponse.setData(errorMap);
        return ResponseEntity.badRequest().body(apiResponse);
//        return errorMap;
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<APIResp()> handleUserServiceExceptions(UserServiceException exception)
    {
        APIResp apiResponse = new APIResp();
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("APPUSR-"+HttpStatus.OK.value());
        apiResponse.setData(null);
        return ResponseEntity.badRequest().body(apiResponse);
//        return errorMap;
    }

    @ExceptionHandler(ServiceAlreadyExistsException.class)
    public ResponseEntity<APIResp()> handleServiceAlreadyExistsException(ServiceAlreadyExistsException ex) {
        APIResp apiResponse = new APIResp();
        apiResponse.setStatusCode(HttpStatus.CONFLICT.value()); // HTTP 409 Conflict
        apiResponse.setSuccess(false);
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setData(null); // No additional data for this error
        apiResponse.setService("SERVICE-CREATION");

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIResp> handleNullPointerException(NullPointerException exception) {
        log.error("[handleNullPointerException] - Unexpected null value encountered: {}", exception.getMessage());

        APIResp apiResponse = new APIResp();
        apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("Unexpected server error occurred. Please try again later.");
        apiResponse.setService("APPUSR-" + HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setData(null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResp> handleGenericException(Exception exception) {
        log.error("[handleGenericException] - Unexpected error: {}", exception.getMessage());

        APIResp apiResponse = new APIResp();
        apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("An unexpected error occurred. Please contact support.");
        apiResponse.setService("APPUSR-" + HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setData(null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }
    @ExceptionHandler(CheckByUsername.class)
    public ResponseEntity<APIResp> handleCheckByUserName(CheckByUsername exception) {
        log.error("[CheckByUserName]", exception);
        APIResp resp = new APIResp();
        resp.setStatuscode(HttpStatus.BAD_REQUEST.value());
        resp.setSuccess(false);
        resp.setMessage(exception.getMessage());
        resp.setService("APPUSR - " + HttpStatus.BAD_REQUEST.value());
        resp.setData(null);

        return ResponseEntity.badRequest().body(resp);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<APIResp> handleUserExistsException(UserExistsException exception) {
        log.error("[CheckByUserName]", exception);
        APIResp resp = new APIResp();
        resp.setStatuscode(HttpStatus.BAD_REQUEST.value());
        resp.setSuccess(false);
        resp.setMessage(exception.getMessage());
        resp.setService("APPUSR - " + HttpStatus.BAD_REQUEST.value());
        resp.setData(null);
        return ResponseEntity.badRequest().body(resp);
    }


}