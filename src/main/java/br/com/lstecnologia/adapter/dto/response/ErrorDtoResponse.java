package br.com.lstecnologia.adapter.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * DTO representing error responses.
 */
public record ErrorDtoResponse(
        @Schema(example = "BAD_REQUEST") String status,
        @Schema(example = "400") int codigo,
        @Schema(example = "{\n" +
                "        \"name\": \"Exists product by name\"\n" +
                "    }") Map<String, String> errors,
        @Schema(example = "2024-01-29T16:33:35.7082957-03:00") ZonedDateTime time) {

    public static ErrorDtoResponse create(String status, int codigo, Map<String, String> errors) {
        return new ErrorDtoResponse(status, codigo, errors, ZonedDateTime.now());
    }

}
