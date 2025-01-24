package com.cars24.csms3.advice;

import com.cars24.csms3.data.resp.APIResp;
import com.cars24.csms3.exceptions.CheckByUsername;
import com.cars24.csms3.exceptions.UserExistsException;
import com.cars24.csms3.exceptions.UserServiceException;
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
    public ResponseEntity<APIResp> handleValidationExceptions(MethodArgumentNotValidException exception) {
        log.info("[handleValidationExceptions]");

        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        APIResp resp = new APIResp();
        resp.setStatuscode(HttpStatus.BAD_REQUEST.value());
        resp.setSuccess(false);
        resp.setMessage("Validation failed");
        resp.setService("APPUSR - " + HttpStatus.BAD_REQUEST.value());
        resp.setData(errorMap);

        return ResponseEntity.badRequest().body(resp);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<APIResp> handleUserServiceException(UserServiceException exception) {
        log.info("[handleUserServiceException] - {}", exception.getMessage());

        APIResp resp = new APIResp();
        resp.setStatuscode(HttpStatus.BAD_REQUEST.value());
        resp.setSuccess(false);
        resp.setMessage(exception.getMessage());
        resp.setService("APPUSR - " + HttpStatus.BAD_REQUEST.value());
        resp.setData(null);

        return ResponseEntity.badRequest().body(resp);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResp> handleGenericException(Exception exception) {
        log.error("[handleGenericException]", exception);

        APIResp resp = new APIResp();
        resp.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        resp.setSuccess(false);
        resp.setMessage("An unexpected error occurred");
        resp.setService("APPUSR - " + HttpStatus.INTERNAL_SERVER_ERROR.value());
        resp.setData(null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
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
