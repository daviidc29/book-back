package com.bookai.service.reader;

public class FallbackReaderStrategy implements ReaderStrategy {
    @Override
    public String generateReaderUrl(String iaId) {
        return null; // El frontend manejará el estado nulo renderizando el texto de fallback
    }

    @Override
    public String getType() {
        return "FALLBACK";
    }
}