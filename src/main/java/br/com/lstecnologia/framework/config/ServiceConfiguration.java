package br.com.lstecnologia.framework.config;

import br.com.lstecnologia.useCase.mapper.ProductModelMapperImpl;
import br.com.lstecnologia.useCase.mapper.ProductResponseDtoMapperImpl;
import br.com.lstecnologia.useCase.service.impl.CreateProductServiceImpl;
import br.com.lstecnologia.useCase.service.impl.ListProductsServiceImpl;
import br.com.lstecnologia.useCase.service.CreateProductService;
import br.com.lstecnologia.useCase.service.ListProductsService;
import br.com.lstecnologia.adapter.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    protected CreateProductService createProductService(ProductResponseDtoMapperImpl productResponseDtoMapper,
                                                     ProductModelMapperImpl productEntityMapper,
                                                     ProductRepository productRepository) {
        return new CreateProductServiceImpl(productResponseDtoMapper, productEntityMapper, productRepository);
    }

    @Bean
    protected ListProductsService listProductsService(ProductResponseDtoMapperImpl productMapper,
                                                   ProductRepository productRepository) {
        return new ListProductsServiceImpl(productMapper, productRepository);
    }

}
