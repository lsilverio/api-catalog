package br.com.lstecnologia.core.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDomain {

    private Long id;

    private String name;

    private LocalDateTime changeDate;

    private LocalDateTime creationDate;

}
