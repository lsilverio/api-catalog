package br.com.lstecnologia.framework.config;

import br.com.lstecnologia.adapter.mapper.ProductAdapterMapper;
import br.com.lstecnologia.adapter.mapper.ProductAdapterMapperImpl;
import br.com.lstecnologia.framework.mapper.ProductEntityMapper;
import br.com.lstecnologia.framework.mapper.ProductEntityMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    /**
     * Configures and provides the ProductEntityMapper bean.
     *
     * @return ProductEntityMapper implementation.
     */
    @Bean
    protected ProductEntityMapper productEntityMapper() {
        return new ProductEntityMapperImpl();
    }

    /**
     * Configures and provides the ProductAdapterMapper bean.
     *
     * @return ProductAdapterMapper implementation.
     */
    @Bean
    protected ProductAdapterMapper productAdapterMapper() {
        return new ProductAdapterMapperImpl();
    }

}
