package br.com.lstecnologia.framework.config;

import br.com.lstecnologia.application.mapper.ProductEntityMapperImpl;
import br.com.lstecnologia.application.mapper.ProductResponseDtoMapperImpl;
import br.com.lstecnologia.application.service.impl.CreateProductServiceImpl;
import br.com.lstecnologia.application.service.impl.ListProductsServiceImpl;
import br.com.lstecnologia.domain.service.CreateProductService;
import br.com.lstecnologia.domain.service.ListProductsService;
import br.com.lstecnologia.framework.persistence.ProductRepository;
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
