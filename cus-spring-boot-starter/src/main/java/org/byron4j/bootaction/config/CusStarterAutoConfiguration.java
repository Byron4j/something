package org.byron4j.bootaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CusStarterProperties.class)
@ConditionalOnClass(CusStarter.class)
@ConditionalOnProperty(prefix = "spring.cus", value = "enabled", matchIfMissing = true)
public class CusStarterAutoConfiguration {

    @Autowired
    private CusStarterProperties cusStarterProperties;

    @Bean
    @ConditionalOnMissingBean(CusStarter.class)
    public CusStarter cusStarter(){
        return new CusStarter(cusStarterProperties);
    }
}
