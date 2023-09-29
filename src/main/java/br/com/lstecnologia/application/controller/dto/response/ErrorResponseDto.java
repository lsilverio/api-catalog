package br.com.lstecnologia.application.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ErrorResponseDto {

    @Schema(example = "2023-09-29T14:09:38.972525600")
    private final String localDateTime;

    @Schema(example = "BAD_REQUEST")
    private final HttpStatus status;

    @Schema(example = "{\n" +
            "        \"name\": \"Exists product by name\"\n" +
            "    }")
    private final Map<String, String> errors;

    public ErrorResponseDto(HttpStatus status, Map<String, String> errors) {
        this.localDateTime = LocalDateTime.now().toString();
        this.status = status;
        this.errors = errors;
    }

}
