package com.bookai.service.reader;
import org.springframework.stereotype.Component;

@Component
public class ReaderFactory {
    public ReaderStrategy getStrategy(String iaId) {
        if (iaId != null && !iaId.isEmpty()) {
            return new EmbedReaderStrategy();
        }
        return new FallbackReaderStrategy();
    }
}