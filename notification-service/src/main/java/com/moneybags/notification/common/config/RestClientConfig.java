package com.moneybags.notification.common.config;

import com.moneybags.notification.notification.integration.CifClientProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    @LoadBalanced
    RestClient.Builder loadBalancedRestClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    RestClient cifRestClient(@LoadBalanced RestClient.Builder builder, CifClientProperties properties) {
        return builder.baseUrl(properties.baseUrl()).build();
    }
}
