package com.bookai.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnalysisResponse {
    
    @JsonProperty("analisis_literario")
    private String analisisLiterario;

    public AnalysisResponse() {}

    public String getAnalisisLiterario() {
        return analisisLiterario;
    }

    public void setAnalisisLiterario(String analisisLiterario) {
        this.analisisLiterario = analisisLiterario;
    }
}