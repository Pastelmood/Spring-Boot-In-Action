package com.il0v3dorayaki.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // create accounts
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        // account 1
        UserDetails shinonome = User
                .builder()
                .username("shinonome")
                .password("{noop}test123")
                .roles("USER","ADMIN", "MANAGER")
                .build();

        // account 2
        UserDetails ayaka = User
                .builder()
                .username("ayaka")
                .password("{noop}test123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(shinonome, ayaka);

    }

    //Restrict URL base on roles
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configure -> configure
                .requestMatchers(HttpMethod.GET, "/").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/wallets").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/wallets/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/api/wallets").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/wallets/**").hasRole("MANAGER")
        );

        // use http basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general. not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();

    }

}
