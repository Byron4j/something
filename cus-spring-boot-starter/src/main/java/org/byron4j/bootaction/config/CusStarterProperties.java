package org.byron4j.bootaction.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.cus")
@Setter
@Getter
public class CusStarterProperties {
    private String arg;
}
