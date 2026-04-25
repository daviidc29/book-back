package com.bookai.client;

import java.util.List;

public class OpenLibrarySearchResponse {
    private List<Doc> docs;

    public List<Doc> getDocs() { return docs; }
    public void setDocs(List<Doc> docs) { this.docs = docs; }

    public static class Doc {
        private String key;
        private String title;
        private List<String> author_name;
        private Integer cover_i;
        private List<String> ia;

        // Getters y Setters explícitos
        public String getKey() { return key; }
        public void setKey(String key) { this.key = key; }
        
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        
        public List<String> getAuthor_name() { return author_name; }
        public void setAuthor_name(List<String> author_name) { this.author_name = author_name; }
        
        public Integer getCover_i() { return cover_i; }
        public void setCover_i(Integer cover_i) { this.cover_i = cover_i; }
        
        public List<String> getIa() { return ia; }
        public void setIa(List<String> ia) { this.ia = ia; }
    }
}