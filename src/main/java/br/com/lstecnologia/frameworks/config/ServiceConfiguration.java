package br.com.lstecnologia.frameworks.config;

import br.com.lstecnologia.useCases.mapper.ProductEntityMapperImpl;
import br.com.lstecnologia.useCases.mapper.ProductResponseDtoMapperImpl;
import br.com.lstecnologia.useCases.service.impl.CreateProductServiceImpl;
import br.com.lstecnologia.useCases.service.impl.ListProductsServiceImpl;
import br.com.lstecnologia.useCases.service.CreateProductService;
import br.com.lstecnologia.useCases.service.ListProductsService;
import br.com.lstecnologia.adapters.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    protected CreateProductService createProductService(ProductResponseDtoMapperImpl productResponseDtoMapper,
                                                     ProductEntityMapperImpl productEntityMapper,
                                                     ProductRepository productRepository) {
        return new CreateProductServiceImpl(productResponseDtoMapper, productEntityMapper, productRepository);
    }

    @Bean
    protected ListProductsService listProductsService(ProductResponseDtoMapperImpl productMapper,
                                                   ProductRepository productRepository) {
        return new ListProductsServiceImpl(productMapper, productRepository);
    }

}
