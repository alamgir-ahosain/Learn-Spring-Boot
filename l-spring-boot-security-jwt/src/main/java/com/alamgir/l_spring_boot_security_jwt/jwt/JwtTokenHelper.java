package com.alamgir.l_spring_boot_security_jwt.jwt;

import java.util.Date;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenHelper {

    Logger logger = LoggerFactory.getLogger(JwtTokenHelper.class);

    private final String SECRET_KEY = "F3r7lG7OZt+2k4Q0l9U+7Vq2g6LkpB1D8uVhb3cW+rY="; // Base64 256-bit key
    private final long TOKEN_EXPIRY_DURATION = 5 * 60 * 1000; // 5 mins

    public SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }






    
    // Create JWT Token
    public String createToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis())) // Creation time
                .expiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRY_DURATION)) // Expire time
                .signWith(getSecretKey()) // "alg": "HS256", "typ": "JWT" auto-set //! JJWT automatically sets `"alg": "HS256"` when using an HMAC key.It also adds `"typ": "JWT"` to mark the  token as a JSON Web Token.
                .compact();
    }

    // Decore and Extract username
    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // Check if token is expired
    public boolean isTokenExpired(String token) {
        Date expiryTime = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        logger.info("JwtTokenHelper : Token Expiry time  :" + expiryTime);
        return expiryTime.before(new Date());
    }

    // Validate token
    public boolean isValidToken(String token, String requestedUsername) {
        String usernameFromToken = extractUsername(token);
        logger.info("JwtTokenHelper : Extract username from Token : " + usernameFromToken);
        return usernameFromToken.equalsIgnoreCase(requestedUsername) && !isTokenExpired(token);
    }
}
