package br.com.lstecnologia.framework.config;

import br.com.lstecnologia.application.gateway.ProductGateway;
import br.com.lstecnologia.application.useCase.CreateProductUseCase;
import br.com.lstecnologia.application.useCase.ListProductsUseCase;
import br.com.lstecnologia.application.useCase.impl.CreateProductUseCaseImpl;
import br.com.lstecnologia.application.useCase.impl.ListProductsUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    /**
     * Configures and provides the CreateProductUseCase bean.
     *
     * @param productGateway Gateway for interacting with product data.
     * @return CreateProductUseCase implementation.
     */
    @Bean
    protected CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCaseImpl(productGateway);
    }

    /**
     * Configures and provides the ListProductsUseCase bean.
     *
     * @param productGateway Gateway for interacting with product data.
     * @return ListProductsUseCase implementation.
     */
    @Bean
    protected ListProductsUseCase listProductsUseCase(ProductGateway productGateway) {
        return new ListProductsUseCaseImpl(productGateway);
    }

}
