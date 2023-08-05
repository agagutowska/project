package com.example.pantry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Auth {
    //private final CustomAccessDeniedHandler customAccessDeniedHandler;
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/login").permitAll()
                            .requestMatchers("/**").authenticated();
                })
                .formLogin(login -> login.permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/login"))
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .inMemoryAuthentication()
                .withUser("user")
                .password("password").roles("USER")
                // .exceptionHandling()
                // .accessDeniedHandler(customAccessDeniedHandler);
                .and().and()
                .build();

        //        .loginPage("login")
        //        .loginProcessingUrl("login")
        //        .failureForwardUrl("loginError")
        //        .defaultSuccessUrl("home")
        //        .logoutSuccessUrl("login")
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}

