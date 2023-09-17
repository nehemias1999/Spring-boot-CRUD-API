package com.example.productsapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class RequestErrorDto {

    private HttpStatus statusCode;
    private String errorMessage;
}
