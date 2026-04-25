package com.bookai.client;
import com.bookai.domain.AnalysisRequest;
import com.bookai.domain.AnalysisResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "n8nClient", url = "${n8n.webhook.url}")
public interface N8nClient {
    @PostMapping(consumes = "application/json")
    AnalysisResponse analyzeContext(@RequestBody AnalysisRequest request);
}