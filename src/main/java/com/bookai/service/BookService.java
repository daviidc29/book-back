package com.bookai.service;

import com.bookai.client.OpenLibraryClient;
import com.bookai.client.OpenLibrarySearchResponse;
import com.bookai.domain.BookDTO;
import com.bookai.service.reader.ReaderFactory;
import com.bookai.service.reader.ReaderStrategy;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final OpenLibraryClient openLibraryClient;
    private final ReaderFactory readerFactory;

    // Constructor explícito
    public BookService(OpenLibraryClient openLibraryClient, ReaderFactory readerFactory) {
        this.openLibraryClient = openLibraryClient;
        this.readerFactory = readerFactory;
    }

    public List<BookDTO> searchBooks(String query) {
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptyList();
        }

        OpenLibrarySearchResponse response = openLibraryClient.searchBooks(query, 10);
        
        if (response == null || response.getDocs() == null) {
            return Collections.emptyList();
        }

        return response.getDocs().stream().map(doc -> {
            String author = (doc.getAuthor_name() != null && !doc.getAuthor_name().isEmpty()) 
                    ? doc.getAuthor_name().get(0) : "Autor desconocido";
            
            String coverUrl = doc.getCover_i() != null 
                    ? "https://covers.openlibrary.org/b/id/" + doc.getCover_i() + "-M.jpg" : null;
            
            String iaId = (doc.getIa() != null && !doc.getIa().isEmpty()) ? doc.getIa().get(0) : null;
            
            ReaderStrategy strategy = readerFactory.getStrategy(iaId);

            // Instanciación directa en lugar del Builder de Lombok para evitar errores de compilación
            BookDTO book = new BookDTO();
            book.setId(doc.getKey());
            book.setTitle(doc.getTitle());
            book.setAuthor(author);
            book.setCoverUrl(coverUrl);
            book.setReadUrl(strategy.generateReaderUrl(iaId));
            book.setReaderType(strategy.getType());
            
            return book;
        }).collect(Collectors.toList());
    }
}