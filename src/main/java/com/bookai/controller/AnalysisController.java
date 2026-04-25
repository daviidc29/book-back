package com.bookai.controller;

import com.bookai.domain.AnalysisRequest;
import com.bookai.domain.AnalysisResponse;
import com.bookai.service.AnalysisService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analysis")
@CrossOrigin(origins = "*") 
public class AnalysisController {
    
    private final AnalysisService analysisService;

    // Inyección de dependencias explícita mediante constructor (Reemplaza @RequiredArgsConstructor)
    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/word-context")
    public ResponseEntity<AnalysisResponse> analyzeWord(@Valid @RequestBody AnalysisRequest request) {
        return ResponseEntity.ok(analysisService.analyze(request));
    }
}