package com.bookai.domain;

import jakarta.validation.constraints.NotBlank;

public class AnalysisRequest {
    
    @NotBlank(message = "La palabra es requerida")
    private String palabra;
    
    @NotBlank(message = "El título del libro es requerido")
    private String libro;
    
    private String autor;
    
    @NotBlank(message = "El párrafo o contexto es requerido")
    private String parrafo;

    // Constructor vacío requerido por la serialización JSON
    public AnalysisRequest() {}

    // Getters y Setters explícitos
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getParrafo() {
        return parrafo;
    }

    public void setParrafo(String parrafo) {
        this.parrafo = parrafo;
    }
}