package com.example.regera.JWT;
import com.example.regera.Model.Request.AuthenticationRequest;
import com.example.regera.Repository.Entity.AccountEntity;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;


    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;


    public String generateToken(AccountEntity account) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(account.getUsername()) // Lưu username vào token
                .setIssuedAt(new Date()) // Thời gian phát hành token
                .setExpiration(expiryDate)// Thời gian hết hạn của token
                .claim("scope",account.getRole().getCode())
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes()) // Ký token với secret key
                .compact(); // Tạo token hoàn chỉnh
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.println("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty.");
        }
        return false;
    }
}