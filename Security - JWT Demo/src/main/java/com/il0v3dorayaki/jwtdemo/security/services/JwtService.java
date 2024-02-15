package com.il0v3dorayaki.jwtdemo.security.services;

import java.util.Date;

public interface JwtService {

    public String createToken();

    public Boolean verifyToken(String jwtToken);

    public String extractUsername(String jwtToken);

    public Date extractExpiration(String jwtToken);

}
