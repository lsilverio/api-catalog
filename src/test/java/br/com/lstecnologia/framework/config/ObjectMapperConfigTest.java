package br.com.lstecnologia.framework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit tests for the ObjectMapperConfig class.
 */
class ObjectMapperConfigTest {

    /**
     * Verifies that the ObjectMapperConfig class properly configures an ObjectMapper instance.
     */
    @Test
    void shouldConfigureObjectMapper() {
        ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();

        ObjectMapper objectMapper = objectMapperConfig.mapper();

        assertNotNull(objectMapper);
    }
}


