package com.example.StringShop.services.auth.impl;

import com.example.StringShop.services.auth.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {


    @Value("${JWT.SECRET_KEY}")
    private String SECRET_KEY ;

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignigKey())
                .build().parseClaimsJws(token)
                .getBody();
    }

    public  <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Key getSignigKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public boolean isTokenValid(String token,UserDetails userDetail){
        final String username = extractUserName(token);
        return (username.equals(userDetail.getUsername()))&& !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return  extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    @Override
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    @Override
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignigKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public String extractUserName(String token) {
        return extractClaim(token,Claims::getSubject);
    }
}
