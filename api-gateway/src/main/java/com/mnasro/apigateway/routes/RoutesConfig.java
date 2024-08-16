package com.mnasro.apigateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {
    @Bean
    public RouteLocator  routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p-> p.path("/doctor/**")
                        .uri("lb://DOCTOR-SERVICE/**"))
                .route(p-> p.path("/patient/**")
                        .uri("lb://PATIENT-SERVICE/**"))
                .route(p-> p.path("/payment/**")
                        .uri("lb://PAYMENT-SERVICE/**"))
                .route(p -> p.path("/swagger-ui/**")
                        .uri("lb://DOCTOR-SERVICE"))
                .route(p -> p.path("/v3/api-docs/**")
                        .uri("lb://DOCTOR-SERVICE"))
                .route(p -> p.path("/swagger-ui/**")
                        .uri("lb://PATIENT-SERVICE"))
                .route(p -> p.path("/v3/api-docs/**")
                        .uri("lb://PATIENT-SERVICE"))
                .route(p -> p.path("/swagger-ui/**")
                        .uri("lb://PAYMENT-SERVICE"))
                .route(p -> p.path("/v3/api-docs/**")
                        .uri("lb://PAYMENT-SERVICE"))
                .build();
    }
}
