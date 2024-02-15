package com.il0v3dorayaki.jwtdemo.security.services;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    // for demo only ... do not keep the secret key here in Production
    private final String secretKey = "5m4tocJQlMg0AGudnlFr0FmoToli1AFZDgZ0eFTsFhVdJUVrWm";

    @Override
    public String createToken() {

        return null;
    }

    @Override
    public Boolean verifyToken(String jwtToken) {

        return null;
    }

    @Override
    public String extractUsername(String jwtToken) {
        return null;
    }

    @Override
    public Date extractExpiration(String jwtToken) {
        return null;
    }


}
