package br.com.lstecnologia.application.controller.exception;

import br.com.lstecnologia.application.controller.dto.response.ErrorResponseDto;
import br.com.lstecnologia.core.exception.ExistsProductByNameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError ->
                    errorResponse.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return newResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistsProductByNameException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationErrors(ExistsProductByNameException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("name", ex.getMessage());
        return newResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponseDto> newResponseEntity(Map<String, String> errorResponse, HttpStatus httpStatus) {
        return new ResponseEntity<ErrorResponseDto>(
                buildErrorResponseDto(httpStatus, errorResponse), new HttpHeaders(), httpStatus);
    }

    private ErrorResponseDto buildErrorResponseDto(HttpStatus httpStatus, Map<String, String> errorResponse) {
        return new ErrorResponseDto(httpStatus, errorResponse);
    }

}
