package br.com.lstecnologia.application.controller.dto.response;

import br.com.lstecnologia.application.dto.response.ErrorResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorResponseDtoTest {

    @Test
    public void testErrorResponseDtoConstructor() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Map<String, String> errors = new HashMap<>();
        errors.put("name", "Exists product by name");

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(status, errors);

        assertEquals(HttpStatus.BAD_REQUEST, errorResponseDto.getStatus());
        assertEquals(errors, errorResponseDto.getErrors());
    }

    @Test
    public void testErrorResponseDtoLocalDateTime() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Map<String, String> errors = new HashMap<>();
        errors.put("name", "Exists product by name");

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(status, errors);

        assertEquals(true, errorResponseDto.getLocalDateTime() != null);
    }

}

