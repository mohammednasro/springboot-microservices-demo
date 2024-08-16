package com.mnasro.apigateway.filters;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component
public class LoggingFilter implements GlobalFilter {
    Logger logger = Logger.getLogger(LoggingFilter.class.getName());
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Request coming.....");
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().toString();


        logger.info("URL : " + url);
        return chain.filter(exchange);
    }
}