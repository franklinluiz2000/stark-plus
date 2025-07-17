package com.client.ws.ws_stark_plus.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Stark Plus", version = "0.0.1", description = "API para atender o client Plus"))
public class SwaggerConfig {
}