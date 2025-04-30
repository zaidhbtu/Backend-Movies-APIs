package com.movieflix.auth.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// Access token Service
@Service
public class JwtService {

    // This JwtService util class to common use
    private static final String SECRET_KEY = "e6eecc3738de4d4e029dd8946b21fcd2f9913b101e74105f403cf4ad19944e73dc6a704455048eee865361732cd0d838ac7ff75614e8e494248e9d8892834558a02cc8d3899f57cbbe60fc59f176b0fe1b560d7eed0b206c38f51e9d1b6ebd07bc379cdb13a7732a2230ab28591c557319feb84738c44227bb327894a326477216389dac8863548eef55d882aa5c3e7cc85d460b38f9134964c0deafda7b3067696ad054fdce94655d81b883e28e3260312851fbabb8d12bf43679ed6ec78143ee82afeda4965098cf7068da6851670301cc0b39661b12edaf38823735c8a985d4888b0d507325df67e6e98b389392ec98cd593b8f4b1f29ffc648b554d8fd0a";

    //extract username from JWT
    public String extractUsername(String token){

        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        // Claims is ultimately a JSON map any values can be added to it, but JWT
        // standard names are provided as type-safe getters and setters for convenience
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //extract information from JWT
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    // decode and get the key
    private Key getSignInKey() {
        // decode SECRET_KEY
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);

        //This will create a new SecretKey instance for use with HMAC-SHA
        // algo based on the specified key byte array
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserDetails userDetails) {

        return generateToken(new HashMap<>(), userDetails);
    }

    // Generate token using Jwt utility class and return token as String
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 25 * 100000))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    // if token is valid by checking if token is expired for current user
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    //if token is Expired
    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    // get expiration date from token
    private Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);
    }

}
