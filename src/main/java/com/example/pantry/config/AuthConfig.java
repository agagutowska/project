package com.example.pantry.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class AuthConfig {

@Bean
protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(auth -> {
                auth.requestMatchers("/login", "/loginError", "/error", "/h2-console/**").permitAll()
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/pantrylogo.jpg").permitAll()
                        .requestMatchers("/**").authenticated();

            })
            .formLogin(login -> login.loginPage("/login").permitAll().failureUrl("/loginError"))
            .logout(logout -> logout.logoutSuccessUrl("/login"))
            .csrf(csrf -> csrf.disable()).build();
}
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }





}

