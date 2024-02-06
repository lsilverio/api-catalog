package br.com.lstecnologia.framework.config;

import br.com.lstecnologia.framework.mapper.ProductEntityMapper;
import br.com.lstecnologia.framework.persistence.repository.JpaProductRepository;
import br.com.lstecnologia.framework.gateway.ProductGatewayImpl;
import br.com.lstecnologia.application.gateway.ProductGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    /**
     * Configures and provides the ProductGateway bean.
     *
     * @param productEntityMapper Mapper for converting between different representations of products.
     * @param productRepository   Repository for accessing product data.
     * @return ProductGateway implementation.
     */
    @Bean
    protected ProductGateway productGateway(ProductEntityMapper productEntityMapper, JpaProductRepository productRepository) {
        return new ProductGatewayImpl(productEntityMapper, productRepository);
    }

}
