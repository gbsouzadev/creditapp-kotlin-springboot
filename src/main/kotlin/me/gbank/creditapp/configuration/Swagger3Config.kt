package me.gbank.creditapp.configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Configuration

@Configuration
class Swagger3Config {

    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("springcreditapp-public")
            .pathsToMatch("/api/customer/**", "/api/credits/**")
            .build()
    }
}