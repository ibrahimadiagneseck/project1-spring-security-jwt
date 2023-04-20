package sn.esp.project1springsecurity.jwt;

import sn.esp.project1springsecurity.security.UserDetailsCustom;
import io.jsonwebtoken.Claims;

import java.security.Key;

public interface JwtService {
    Claims extractClaims(String token);

    Key getKey();

    String generateToken(UserDetailsCustom userDetailsCustom);

    boolean isValidToken(String token);
}
