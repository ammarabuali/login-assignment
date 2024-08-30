package org.example.loginapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Account Management and Banking Services API")
                        .version("v1")
                        .description("API for user management and banking operations. Supports user registration, authentication, login, and bank account creation.")
                );
    }
}
