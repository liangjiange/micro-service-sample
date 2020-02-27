package com.liangjiange.gateway.config;

import com.liangjiange.gateway.auth.bearer.BearerTokenReactiveAuthenticationManager;
import com.liangjiange.gateway.auth.bearer.ServerHttpBearerAuthenticationConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@EnableWebFluxSecurity
public class SecurityConfig {

    /**
     * security的鉴权排除列表
     */
    private static final String[] excludedAuthPages = {
            "/auth/login",
            "/auth/test"
    };

    /**
     * For Spring Security webflux, a chain of filters will provide user authentication
     * and authorization, we add custom filters to enable JWT token approach.
     *
     * @param http An initial object to build common filter scenarios.
     *             Customized filters are added here.
     * @return SecurityWebFilterChain A filter chain for web exchanges that will
     * provide security
     **/
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        http
                .authorizeExchange()
                .pathMatchers(excludedAuthPages).permitAll()
                .pathMatchers(HttpMethod.OPTIONS).permitAll()

                .anyExchange().authenticated()
                .and()
                .addFilterAt(bearerAuthenticationFilter(), SecurityWebFiltersOrder.AUTHENTICATION)

                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable();

        /**
         .authorizeExchange()
         .pathMatchers("/openapi/**")
         .authenticated()
         .and()
         //TODO openapi采用client id,client secret的认证策略
         .addFilterAt(bearerAuthenticationFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
         **/


        return http.build();
    }

    /**
     * Use the already implemented logic by AuthenticationWebFilter and set a custom
     * converter that will handle requests containing a Bearer token inside
     * the HTTP Authorization header.
     * Set a dummy authentication manager to this filter, it's not needed because
     * the converter handles this.
     *
     * @return bearerAuthenticationFilter that will authorize requests containing a JWT
     */
    private AuthenticationWebFilter bearerAuthenticationFilter() {
        AuthenticationWebFilter bearerAuthenticationFilter;
        Function<ServerWebExchange, Mono<Authentication>> bearerConverter;
        ReactiveAuthenticationManager authManager;

        authManager = new BearerTokenReactiveAuthenticationManager();
        bearerAuthenticationFilter = new AuthenticationWebFilter(authManager);
        bearerConverter = new ServerHttpBearerAuthenticationConverter();

        bearerAuthenticationFilter.setAuthenticationConverter(bearerConverter);
        bearerAuthenticationFilter.setRequiresAuthenticationMatcher(ServerWebExchangeMatchers.pathMatchers("/api/**"));

        return bearerAuthenticationFilter;
    }

}
