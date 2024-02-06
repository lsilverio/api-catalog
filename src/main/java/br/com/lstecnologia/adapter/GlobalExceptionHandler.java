package br.com.lstecnologia.adapter;

import br.com.lstecnologia.adapter.dto.response.ErrorDtoResponse;
import br.com.lstecnologia.framework.exception.ObjectNotFoundException;
import br.com.lstecnologia.application.useCase.exception.ExistsProductByNameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDtoResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        // Extract field errors from the exception and create an error response
        Map<String, String> errorResponse = ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(HashMap::new,
                        (map, fieldError) -> map.put(fieldError.getField(), fieldError.getDefaultMessage()),
                        HashMap::putAll);
        return newResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistsProductByNameException.class)
    public ResponseEntity<ErrorDtoResponse> handleExistsProductByNameException(ExistsProductByNameException ex) {
        // Handle the custom exception for products with existing names
        Map<String, String> errorResponse = Collections.singletonMap("name", ex.getMessage());
        return newResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorDtoResponse> handleObjectNotFoundException(ObjectNotFoundException ex) {
        // Handle the custom exception for object not found
        Map<String, String> errorResponse = Collections.singletonMap("", ex.getMessage());
        return newResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorDtoResponse> newResponseEntity(Map<String, String> errorResponse, HttpStatus httpStatus) {
        // Create a new ResponseEntity with the appropriate HTTP status, headers, and error response body
        return new ResponseEntity<>(
                buildErrorResponseDto(httpStatus, errorResponse),
                new HttpHeaders(), httpStatus);
    }

    private ErrorDtoResponse buildErrorResponseDto(HttpStatus httpStatus, Map<String, String> errorResponse) {
        // Build an ErrorDtoResponse with the provided HTTP status, error code, and error response map
        return ErrorDtoResponse.create(httpStatus.name(), httpStatus.value(), errorResponse);
    }

}
