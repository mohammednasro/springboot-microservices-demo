package com.mnasro.patient.decoder;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("Bad Request - Invalid input.");
            case 404:
                return new OpenApiResourceNotFoundException("Resource not found.");
            case 500:
                return new InternalServerErrorException("Internal Server Error.");
            default:
                return new Exception("Generic error message");
        }
    }
}
