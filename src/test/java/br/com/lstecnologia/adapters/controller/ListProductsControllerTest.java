package br.com.lstecnologia.adapters.controller;

import br.com.lstecnologia.useCases.dto.response.PageableResponseDto;
import br.com.lstecnologia.useCases.dto.response.ProductResponseDto;
import br.com.lstecnologia.useCases.service.ListProductsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit tests for ListProductsController.
 */
class ListProductsControllerTest {

    @InjectMocks
    private ListProductsController listProductsController;

    @Mock
    private ListProductsService listProductsService;

    @Mock
    private PageableResponseDto pageableResponseDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test for the execute method in ListProductsController.
     */
    @Test
    @DisplayName("List Products - Success")
    void shouldExecuteListProductsSuccessfully() {
        Pageable pageable = PageRequest.of(0, 10);

        when(listProductsService.execute(pageable)).thenReturn(pageableResponseDto);

        ResponseEntity<PageableResponseDto<ProductResponseDto>> responseEntity = listProductsController.execute(pageable);

        assertEquals(200, responseEntity.getStatusCodeValue());

        verify(listProductsService, times(1)).execute(pageable);
    }

}

