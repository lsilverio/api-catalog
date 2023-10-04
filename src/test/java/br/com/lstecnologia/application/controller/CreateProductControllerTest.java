package br.com.lstecnologia.application.controller;

import br.com.lstecnologia.application.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.dto.response.ProductResponseDto;
import br.com.lstecnologia.application.service.CreateProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(CreateProductController.class)
@ExtendWith(SpringExtension.class)
public class CreateProductControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateProductService createProductService;

    @Test
    public void testCreateProduct() throws Exception {
        ProductRequestDto requestDto = new ProductRequestDto("Sample Product");

        LocalDateTime now = LocalDateTime.now();
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(1L);
        responseDto.setName("Sample Product");
        responseDto.setChangeDate(now);
        responseDto.setCreationDate(now);

        Mockito.when(createProductService.execute(Mockito.any(ProductRequestDto.class))).thenReturn(responseDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/products")
                        .content(new ObjectMapper().writeValueAsString(requestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        ProductResponseDto createdProduct = objectMapper.readValue(responseBody, ProductResponseDto.class);

        assertEquals(responseDto.getId(), createdProduct.getId());
        assertEquals(responseDto.getName(), createdProduct.getName());
    }

}
