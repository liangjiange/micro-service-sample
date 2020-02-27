package com.liangjiange.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * 启动
 *
 * @author liangjiange
 * @date 2019-02-12
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("service_test", r -> r.path("/service_test/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8081/"))
                .route("service_auth", r -> r.path("/auth/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://service-auth"))
                .route("service_aaa", r -> r.path("/api/service_a/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://service-a"))
                .route("service_a_openfeign", r -> r.path("/api/service_a_openfeign/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://service-a-openfeign"))
                .route("service_b", r -> r.path("/api/service_b/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://service-b"))
                .build();
    }

}
