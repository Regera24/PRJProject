package com.example.regera.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${app.jwtSecret}")
    private String jwtSecret;

    private final String[] PUBLIC_ENDPOINTS = {
            "/login", "/city", "/tag","/job/**", "/check/**","/public/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request ->
                request.requestMatchers(PUBLIC_ENDPOINTS).permitAll()
                        .requestMatchers("/candidate/**").hasAnyAuthority("SCOPE_USER")
                        .requestMatchers("/company/**").hasAnyAuthority("SCOPE_COMPANY")
                        .anyRequest().authenticated());

        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        http.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()));

        http.oauth2ResourceServer(oath2 ->
            oath2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder()))
        );
        return http.build();
    }

    private UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);  // Cho phép gửi credentials (cookie, token)
        config.addAllowedOrigin("http://localhost:3000");  // Cho phép nguồn React App
        config.addAllowedHeader("*");  // Cho phép tất cả các headers
        config.addAllowedMethod("*");  // Cho phép tất cả các phương thức HTTP

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);  // Áp dụng cho tất cả các đường dẫn
        return source;
    }

    @Bean
    JwtDecoder jwtDecoder() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(jwtSecret.getBytes(), "HS512");
        return NimbusJwtDecoder
                .withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    };
}