package com.bookai.service.reader;

public class EmbedReaderStrategy implements ReaderStrategy {
    @Override
    public String generateReaderUrl(String iaId) {
        return "https://archive.org/embed/" + iaId + "?ui=embed";
    }
    public String getType() { return "EMBED"; }
    
}