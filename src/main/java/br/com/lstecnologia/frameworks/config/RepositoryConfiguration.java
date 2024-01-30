package br.com.lstecnologia.frameworks.config;

import br.com.lstecnologia.frameworks.persistence.JpaProductRepository;
import br.com.lstecnologia.adapters.repository.ProductRepository;
import br.com.lstecnologia.adapters.repository.impl.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    protected ProductRepository productRepository(JpaProductRepository productRepository) {
        return new ProductRepositoryImpl(productRepository);
    }

}
