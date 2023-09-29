package br.com.lstecnologia.application.controller.exception;

import br.com.lstecnologia.application.controller.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.controller.dto.response.ErrorResponseDto;
import br.com.lstecnologia.core.domain.ProductDomain;
import br.com.lstecnologia.core.exception.ExistsProductByNameException;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    @Test
    public void testHandleValidationErrors() {
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(new FieldError("productRequestDto", "name", "Name cannot be null"));

        ProductRequestDto requestDto = new ProductRequestDto(null);

        MethodArgumentNotValidException ex = createMethodArgumentNotValidException(requestDto, fieldErrors);

        ResponseEntity<ErrorResponseDto> responseEntity = exceptionHandler.handleValidationErrors(ex);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        ErrorResponseDto errorResponseDto = responseEntity.getBody();
        assertEquals(HttpStatus.BAD_REQUEST, errorResponseDto.getStatus());
        assertEquals("Name cannot be null", errorResponseDto.getErrors().get("name"));
    }

    @Test
    public void testHandleExistsProductByNameException() {
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

        ExistsProductByNameException ex = new ExistsProductByNameException("Exists product by name");

        ResponseEntity<ErrorResponseDto> responseEntity = exceptionHandler.handleValidationErrors(ex);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        ErrorResponseDto errorResponseDto = responseEntity.getBody();
        assertEquals(HttpStatus.BAD_REQUEST, errorResponseDto.getStatus());
        assertEquals("Exists product by name", errorResponseDto.getErrors().get("name"));
    }

    private MethodArgumentNotValidException createMethodArgumentNotValidException(
            ProductRequestDto requestDto, List<FieldError> fieldErrors) {
        BindingResult bindingResult = new BeanPropertyBindingResult(requestDto, "productRequestDto");
        fieldErrors.forEach(bindingResult::addError);

        WebDataBinder binder = new WebDataBinder(requestDto, "productRequestDto");
        binder.validate();

        return new MethodArgumentNotValidException(
                (MethodParameter) null,
                bindingResult);
    }
}
