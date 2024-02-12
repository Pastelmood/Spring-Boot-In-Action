package com.il0v3dorayaki.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC ... no more hardcode users :-)
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT account_name, pwd, is_active from accounts where account_name=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT account_name, role from permissions where account_name=?");

        return jdbcUserDetailsManager;
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
