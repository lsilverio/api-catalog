package br.com.lstecnologia.adapters.controller;

import br.com.lstecnologia.useCases.dto.request.ProductRequestDto;
import br.com.lstecnologia.useCases.dto.response.ProductResponseDto;
import br.com.lstecnologia.useCases.service.CreateProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CreateProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CreateProductService createProductService;

    @InjectMocks
    private CreateProductController createProductController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(createProductController).build();
    }

    /**
     * Test the create product endpoint.
     * Should create a new product with the provided information and return the details of the created product.
     *
     * @throws Exception If an error occurs during the test.
     */
    @Test
    @DisplayName("Create Products - Success")
    void shouldCreateProductSuccessfully() throws Exception {
        ProductRequestDto requestDto = new ProductRequestDto("Product Name");

        when(createProductService.execute(any(ProductRequestDto.class))).thenReturn(buildProductResponseDto());

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(convertObjectToJson(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Product Name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.changeDate").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.creationDate").isNotEmpty())
                .andReturn();
    }

    /**
     * Utility method to convert objects to JSON format for testing.
     *
     * @param obj The object to be converted to JSON.
     * @return JSON representation of the object.
     */
    private String convertObjectToJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Utility method to build an instance of ProductResponseDto for simulating the service response.
     *
     * @return A ProductResponseDto instance with dummy data.
     */
    private static ProductResponseDto buildProductResponseDto() {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(1L);
        responseDto.setName("Product Name");
        responseDto.setCreationDate(LocalDateTime.now());
        responseDto.setChangeDate(LocalDateTime.now());
        return responseDto;
    }

}
