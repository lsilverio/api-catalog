package br.com.lstecnologia.framework.config;

import br.com.lstecnologia.framework.persistence.JpaProductRepository;
import br.com.lstecnologia.adapter.repository.ProductRepository;
import br.com.lstecnologia.adapter.repository.impl.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    protected ProductRepository productRepository(JpaProductRepository productRepository) {
        return new ProductRepositoryImpl(productRepository);
    }

}
