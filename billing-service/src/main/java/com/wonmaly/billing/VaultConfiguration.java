package com.wonmaly.billing;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "user")
public class VaultConfiguration {
    private String otp;
    private String userName;
    private String password;
}
