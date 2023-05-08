package com.wonmaly.billing;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "token")
public class ConsulConfiguration {
    private String accessTokenTimeout;
    private String refreshTokenTimeout;
}
