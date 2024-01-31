package br.com.lstecnologia.framework.config;

import br.com.lstecnologia.adapter.repository.ProductRepository;
import br.com.lstecnologia.useCase.mapper.ProductModelMapperImpl;
import br.com.lstecnologia.useCase.mapper.ProductResponseDtoMapperImpl;
import br.com.lstecnologia.useCase.service.CreateProductService;
import br.com.lstecnologia.useCase.service.ListProductsService;
import br.com.lstecnologia.useCase.service.impl.CreateProductServiceImpl;
import br.com.lstecnologia.useCase.service.impl.ListProductsServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Unit tests for the ServiceConfiguration class.
 */
class ServiceConfigurationTest {

    /**
     * Verifies that the ServiceConfiguration class creates a CreateProductService bean.
     */
    @Test
    void shouldCreateCreateProductServiceBean() {
        ProductResponseDtoMapperImpl productResponseDtoMapper = mock(ProductResponseDtoMapperImpl.class);
        ProductModelMapperImpl productEntityMapper = mock(ProductModelMapperImpl.class);
        ProductRepository productRepository = mock(ProductRepository.class);

        ServiceConfiguration serviceConfiguration = new ServiceConfiguration();

        CreateProductService createProductService = serviceConfiguration
                .createProductService(productResponseDtoMapper, productEntityMapper, productRepository);

        assertNotNull(createProductService);
        assertTrue(createProductService instanceof CreateProductServiceImpl);
    }

    /**
     * Verifies that the ServiceConfiguration class creates a ListProductsService bean.
     */
    @Test
    void shouldCreateListProductsServiceBean() {
        ProductResponseDtoMapperImpl productMapper = mock(ProductResponseDtoMapperImpl.class);
        ProductRepository productRepository = mock(ProductRepository.class);

        ServiceConfiguration serviceConfiguration = new ServiceConfiguration();

        ListProductsService listProductsService = serviceConfiguration.listProductsService(productMapper, productRepository);

        assertNotNull(listProductsService);
        assertTrue(listProductsService instanceof ListProductsServiceImpl);
    }
}
