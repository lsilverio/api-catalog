package br.com.lstecnologia.adapters;

import br.com.lstecnologia.useCases.dto.response.ErrorResponseDto;
import br.com.lstecnologia.useCases.service.exception.ExistsProductByNameException;
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
    public ResponseEntity<ErrorResponseDto> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errorResponse = ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(HashMap::new,
                        (map, fieldError) -> map.put(fieldError.getField(), fieldError.getDefaultMessage()),
                        HashMap::putAll);
        return newResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistsProductByNameException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationErrors(ExistsProductByNameException ex) {
        Map<String, String> errorResponse = Collections.singletonMap("name", ex.getMessage());
        return newResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponseDto> newResponseEntity(Map<String, String> errorResponse, HttpStatus httpStatus) {
        return new ResponseEntity<>(
                buildErrorResponseDto(httpStatus, errorResponse),
                new HttpHeaders(), httpStatus);
    }

    private ErrorResponseDto buildErrorResponseDto(HttpStatus httpStatus, Map<String, String> errorResponse) {
        return ErrorResponseDto.create(httpStatus.name(), httpStatus.value(), errorResponse);
    }

}

