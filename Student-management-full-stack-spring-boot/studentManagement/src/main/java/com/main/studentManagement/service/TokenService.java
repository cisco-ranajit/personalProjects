package com.main.studentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class TokenService {
    private JwtEncoder jwtEncoder;
    @Autowired
    public TokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }


    public String generateJwtToken(Authentication authentication) {
        Instant now = Instant.now();
        String scopes = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(""));

        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(new Date(System.currentTimeMillis()).toInstant())
                .expiresAt(new Date(System.currentTimeMillis() + 1000*30*3).toInstant())
                .subject(authentication.getName())
                .claim("roles",scopes)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }

    public boolean validatejwt(String token){
        return true;
    }



}
