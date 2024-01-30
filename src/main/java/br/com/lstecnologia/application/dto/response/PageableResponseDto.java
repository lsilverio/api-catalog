package br.com.lstecnologia.application.dto.response;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageableResponseDto<T> {

    private long totalElements;
    private int totalPages;
    private int numberOfElementsCurrentPage;
    private boolean lastPage;
    private boolean firstPage;
    private int numberOfCurrentPage;
    private List<T> elements;

    public PageableResponseDto(Page<T> page, List<T> elements) {
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.numberOfElementsCurrentPage = page.getNumberOfElements();
        this.numberOfCurrentPage = page.getNumber();
        this.firstPage = page.isFirst();
        this.lastPage = page.isLast();
        this.elements = elements;
    }

}
