package com.medibill.main.common;

import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
@Service
public class TokenService {
    private JwtEncoder jwtEncoder;
    private JwtDecoder jwtDecoder;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public TokenService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, PasswordEncoder passwordEncoder){
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
        this.passwordEncoder = passwordEncoder;
    }

    public String generateJwt(Authentication auth){
        Instant now = Instant.now();
        String scope = auth.getAuthorities()
        .stream()
        .map(GrantedAuthority :: getAuthority)
        .collect(Collectors.joining(""));

        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
        .issuer("self")
        .issuedAt(new Date(System.currentTimeMillis()).toInstant())
        .expiresAt(new Date(System.currentTimeMillis() + 1000*60*3).toInstant())
        .subject(auth.getName())
        .claim("roles", scope)
        .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }

    public boolean validateJwt(String token){
        return true;
    }
}
