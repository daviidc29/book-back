package com.bookai.service;

import com.bookai.client.N8nClient;
import com.bookai.domain.AnalysisRequest;
import com.bookai.domain.AnalysisResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnalysisService {
    
    // Instancia explícita del Logger (Reemplaza @Slf4j)
    private static final Logger log = LoggerFactory.getLogger(AnalysisService.class);
    
    private final N8nClient n8nClient;

    // Constructor explícito
    public AnalysisService(N8nClient n8nClient) {
        this.n8nClient = n8nClient;
    }

    public AnalysisResponse analyze(AnalysisRequest request) {
        log.info("Enviando petición a n8n para la palabra: {}", request.getPalabra());
        try {
            return n8nClient.analyzeContext(request);
        } catch (Exception e) {
            log.error("Error al comunicar con n8n: ", e);
            throw new RuntimeException("Error al analizar la palabra mediante el agente IA");
        }
    }
}