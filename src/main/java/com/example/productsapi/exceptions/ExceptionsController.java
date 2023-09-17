package com.example.productsapi.exceptions;

import com.example.productsapi.dto.response.RequestErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(EmptyProductsListException.class)
    public ResponseEntity<?> emptyProductsList(EmptyProductsListException emptyProductsListException) {
        RequestErrorDto requestErrorDto = new RequestErrorDto(HttpStatus.NOT_FOUND, emptyProductsListException.getMessage());
        return new ResponseEntity<>(requestErrorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFound(ProductNotFoundException productNotFoundException) {
        RequestErrorDto requestErrorDto = new RequestErrorDto(HttpStatus.NOT_FOUND, productNotFoundException.getMessage());
        return new ResponseEntity<>(requestErrorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDataEntryException.class)
    public ResponseEntity<?> invalidDataEntry(InvalidDataEntryException invalidDataEntryException) {
        RequestErrorDto requestErrorDto = new RequestErrorDto(HttpStatus.BAD_REQUEST, invalidDataEntryException.getMessage());
        return new ResponseEntity<>(requestErrorDto, HttpStatus.BAD_REQUEST);
    }
}
