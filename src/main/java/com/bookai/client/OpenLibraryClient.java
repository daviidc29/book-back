package com.bookai.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openLibraryClient", url = "${openlibrary.api.url}")
public interface OpenLibraryClient {
    @GetMapping(value = "/search.json", produces = "application/json")
    OpenLibrarySearchResponse searchBooks(@RequestParam("q") String query, @RequestParam("limit") int limit);
}