package br.com.lstecnologia.adapter.dto.response;

import lombok.Data;

import java.util.List;

/**
 * DTO representing pageable responses.
 * @param <T> Type of elements in the list.
 */
@Data
public class PageableDtoResponse<T> {

    private int totalPages;

    private long totalElements;

    private int numberOfElementsCurrentPage;

    private int numberOfCurrentPage;

    private boolean firstPage;

    private boolean lastPage;

    private List<T> elements;

    public PageableDtoResponse(int totalPages, long totalElements, int numberOfElementsCurrentPage,
                               int numberOfCurrentPage, boolean firstPage, boolean lastPage, List<T> elements) {

        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.numberOfElementsCurrentPage = numberOfElementsCurrentPage;
        this.numberOfCurrentPage = numberOfCurrentPage;
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.elements = elements;
    }

}
