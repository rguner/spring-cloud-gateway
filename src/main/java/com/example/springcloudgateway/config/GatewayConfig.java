package com.example.springcloudgateway.config;

import com.example.springcloudgateway.model.Hello;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("modify_request_body", r -> r.path("/v1/hello/**")
                        .filters(f -> f.modifyRequestBody(
                                String.class, Hello.class, MediaType.APPLICATION_JSON_VALUE,
                                (exchange, s) -> Mono.just(new Hello("title", s))))
                        .uri("http://localhost:8080")
                )
                .build();
    }

}