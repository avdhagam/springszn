package com.cars24.csms.advice;


import com.cars24.csms.data.resp.APIResponse;
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
        apiResponse.setStatus(HttpStatus.OK.value());
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
        apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("APPUSR-"+HttpStatus.OK.value());
        apiResponse.setData(null);
        return ResponseEntity.badRequest().body(apiResponse);
//        return errorMap;
    }}
    /*@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIResponse> handleRuntimeExceptions(RuntimeException exception) {
        log.error("[handleRuntimeExceptions] Exception occurred: ", exception);

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", "Internal server error occurred.");
        errorMap.put("message", exception.getMessage());

        // Respond with 500 (Internal Server Error)
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("invalid data");
        apiResponse.setService("APPUSR-"+HttpStatus.OK.value());
        apiResponse.setData(errorMap);
        return ResponseEntity.badRequest().body(apiResponse);

    }

} */
