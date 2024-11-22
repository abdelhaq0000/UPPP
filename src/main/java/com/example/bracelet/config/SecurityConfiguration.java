package com.example.bracelet.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfiguration {
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> {
                        auth.requestMatchers("/api/v1/user/save").permitAll();
                        auth.requestMatchers("/api/users/**").permitAll();
                        auth.requestMatchers("/api/v1/user/login").permitAll();
                        auth.requestMatchers("/registration/**").permitAll();
                        auth.requestMatchers("/api/data").permitAll();
                        auth.requestMatchers("/api/getCurrentData").permitAll();
                        auth.requestMatchers("/api/users/**").permitAll();



                        auth.anyRequest().authenticated();
                    });
            return http.build();
        }

        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() {
            return (web) -> web.ignoring().requestMatchers("/api/v1/user/save", "/api/v1/user/login");
        }
    }

