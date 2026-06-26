package com.ts.shipment_marketplace.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private final String SECRET =
            "mySecretKeymySecretKeymySecretKey";

    public String generateToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                    new Date(
                       System.currentTimeMillis()
                       + 86400000))
                .signWith(
                  Keys.hmacShaKeyFor(
                    SECRET.getBytes()),
                  SignatureAlgorithm.HS256)
                .compact();
    }
    
    public String extractUsername(String token){

        return Jwts.parserBuilder()
                .setSigningKey(
                    SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
	
	
}
