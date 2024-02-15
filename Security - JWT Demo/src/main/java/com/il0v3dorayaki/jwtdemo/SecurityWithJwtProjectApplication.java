package com.il0v3dorayaki.jwtdemo;

import com.il0v3dorayaki.jwtdemo.security.services.JwtService;
import com.il0v3dorayaki.jwtdemo.security.services.JwtServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityWithJwtProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityWithJwtProjectApplication.class, args);
	}



}
