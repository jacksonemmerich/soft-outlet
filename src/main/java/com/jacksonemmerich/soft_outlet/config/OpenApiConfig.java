package com.jacksonemmerich.soft_outlet.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "E-Commerce API",
        version = "V1.0",
        description = "Api soft-outlet para e-commerce"
))
public class OpenApiConfig {



}