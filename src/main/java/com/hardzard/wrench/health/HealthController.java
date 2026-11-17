package com.hardzard.wrench.health;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Health contract used by the frontend backend-switch (docs/plans/04-backend-mode.md).
 * GET /api/health -> 200 { "ok": true, "version": "...", "features": [] }
 */
@RestController
@RequestMapping("/api")
public class HealthController {

    public record HealthResponse(boolean ok, String version, List<String> features) {}

    private final String version;

    public HealthController(@Value("${app.version:0.1.0}") String version) {
        this.version = version;
    }

    @GetMapping("/health")
    public HealthResponse health() {
        return new HealthResponse(true, version, List.of());
    }
}
