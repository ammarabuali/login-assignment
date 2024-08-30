package org.example.loginapi.service.jwt;

public interface JwtService {
    String generateToken(String username);
}
