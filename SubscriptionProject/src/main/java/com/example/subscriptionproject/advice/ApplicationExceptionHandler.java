package com.example.subscriptionproject.advice;

import com.example.subscriptionproject.DTOs.ErrorDTO;
import com.example.subscriptionproject.DTOs.ViolationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;



@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO handleInvalidArgument(MethodArgumentNotValidException ex) {
        List<ViolationDTO> violationDTOS = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            violationDTOS.add(new ViolationDTO(error.getField(), error.getDefaultMessage()));
        });
        ErrorDTO errorDTO = new ErrorDTO("Constraint violation", violationDTOS);
        return errorDTO;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResponseStatusException.class)
    public ErrorDTO handleBusinessException(ResponseStatusException ex) {
        String errorMessage = ex.getMessage();
        return new ErrorDTO(errorMessage);
    }
}
