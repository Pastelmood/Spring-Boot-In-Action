package com.il0v3dorayaki.jwtdemo.security.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceImplTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void verifyTokenShouldBeTrue() {
        String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJpbDB2M0RvcmF5YWtpLmNvbSJ9.gGI-AdSXHNc0oPr1Ulv6hZB7aivbZBqfy207T04U_oY";
        JwtServiceImpl jwtService = new JwtServiceImpl();

        Boolean expected = true;
        Boolean actual = jwtService.verifyToken(jwtToken);

        assertEquals(expected, actual);
    }
}