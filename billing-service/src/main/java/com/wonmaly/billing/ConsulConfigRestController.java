package com.wonmaly.billing;

import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RefreshScope
@RestController
@AllArgsConstructor
public class ConsulConfigRestController {
    private final ConsulConfiguration consulConfiguration;
    private final VaultConfiguration vaultConfiguration;

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        return Map.of(
                "consulConfiguration", consulConfiguration,
                "vaultConfiguration", vaultConfiguration
        );
    }
}
