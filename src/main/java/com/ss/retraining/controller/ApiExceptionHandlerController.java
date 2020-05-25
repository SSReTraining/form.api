package com.ss.retraining.controller;

import com.ss.retraining.dto.MessageDTO;
import com.ss.retraining.exception.ConflictException;
import com.ss.retraining.exception.DatabaseItemNotFoundException;
import com.ss.retraining.exception.InvalidDataException;
import com.ss.retraining.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ApiExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<MessageDTO> handleExceptions(ServiceException e) {
        HttpStatus httpStatus;
        if (e instanceof DatabaseItemNotFoundException) {
            httpStatus = HttpStatus.NOT_FOUND;
        }  else if (e instanceof ConflictException) {
            httpStatus = HttpStatus.CONFLICT;
        } else if (e instanceof InvalidDataException) {
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(httpStatus).body(new MessageDTO(e.getMessage()));
    }
}
