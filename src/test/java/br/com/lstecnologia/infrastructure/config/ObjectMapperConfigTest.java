package br.com.lstecnologia.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
public class ObjectMapperConfigTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(ObjectMapperConfig.class);
    }

    @Test
    public void testObjectMapperConfiguration() {
        ObjectMapper objectMapper = context.getBean("objectMapper", ObjectMapper.class);

        assertTrue(objectMapper.getRegisteredModuleIds().contains("com.fasterxml.jackson.datatype.jsr310.JavaTimeModule"));
    }
}


