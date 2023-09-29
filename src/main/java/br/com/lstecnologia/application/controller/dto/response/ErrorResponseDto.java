package br.com.lstecnologia.application.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    private final Timestamp timestamp;
    private final HttpStatus status;
    private final Map<String, String> errors;

    public ErrorResponseDto(HttpStatus status, Map<String, String> errors) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = status;
        this.errors = errors;
    }

}
