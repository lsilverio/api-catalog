package br.com.lstecnologia.adapter;

import br.com.lstecnologia.application.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.dto.response.ErrorResponseDto;
import br.com.lstecnologia.application.service.exception.ExistsProductByNameException;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void handleValidationErrors_shouldReturnBadRequestWithFieldErrors() {
        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(new FieldError("productRequestDto", "name", "Name cannot be null"));

        ProductRequestDto requestDto = new ProductRequestDto(null);
        MethodArgumentNotValidException ex = createMethodArgumentNotValidException(requestDto, fieldErrors);

        ResponseEntity<ErrorResponseDto> responseEntity = globalExceptionHandler.handleValidationErrors(ex);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody().errors().containsValue("Name cannot be null"));
    }

    @Test
    void handleExistsProductByNameException_shouldReturnBadRequestWithErrorMessage() {
        ExistsProductByNameException ex = new ExistsProductByNameException("Product with this name already exists");

        ResponseEntity<ErrorResponseDto> responseEntity = globalExceptionHandler.handleValidationErrors(ex);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody().errors().containsValue("Product with this name already exists"));
    }

    private MethodArgumentNotValidException createMethodArgumentNotValidException(ProductRequestDto productRequestDto, List<FieldError> fieldErrors) {
        BindingResult bindingResult = new BeanPropertyBindingResult(productRequestDto, "productRequestDto");
        fieldErrors.forEach(bindingResult::addError);

        WebDataBinder binder = new WebDataBinder(productRequestDto, "productRequestDto");
        binder.validate();

        return new MethodArgumentNotValidException(
                (MethodParameter) null,
                bindingResult);
    }

}

