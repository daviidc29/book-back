package com.bookai.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    
    // Habilita el logging detallado para las peticiones de Feign (OpenLibrary y n8n)
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}