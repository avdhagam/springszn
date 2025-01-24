package com.cars24.csms.advice;

import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import jakarta.validation.ValidationException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
        log.info("[handleValidationExceptions]");

        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });

        ApiResponse errorResponse = new ApiResponse();
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setSuccess(false);
        errorResponse.setMessage("User already exists with the given username");
        errorResponse.setService("APPUSR-" + HttpStatus.BAD_REQUEST.value());
        errorResponse.setData(errorMap);
//        return ResponseEntity.badRequest().body(errorResponse);

        return ResponseEntity.badRequest().body(errorMap);
//        return errorMap;

    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ApiResponse> handleUserServiceException(UserServiceException exception)
    {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("APPUSR-"+HttpStatus.OK.value());
        apiResponse.setData(null);
        return ResponseEntity.badRequest().body(apiResponse);

    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse> handleNullPointerException(NullPointerException exception) {
        log.error("[handleNullPointerException] - Unexpected null value encountered: {}", exception.getMessage());

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("Unexpected server error occurred. Please try again later.");
        apiResponse.setService("APPUSR-" + HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setData(null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception exception) {
        log.error("[handleGenericException] - Unexpected error: {}", exception.getMessage());

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("An unexpected error occurred. Please contact support.");
        apiResponse.setService("APPUSR-" + HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setData(null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }
}
