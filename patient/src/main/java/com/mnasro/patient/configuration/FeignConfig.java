package com.mnasro.patient.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mnasro.patient.decoder.CustomErrorDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
