package br.com.lstecnologia.domain.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Represents a generic response model for entities.
 */
@Data
@ToString
public class GenericModelResponse {

    private Long id;
    private LocalDateTime creationDate;
    private LocalDateTime changeDate;

}
