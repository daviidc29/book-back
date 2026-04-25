package com.bookai.service.reader;

public interface ReaderStrategy {
    String generateReaderUrl(String iaId);
    String getType();
}