package comt.est_server.testserver.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret.key}")
    private String JWT_SECRET_KEY;

    private static final long ACCESSTOKEN_EXPIRATION= 15 * 60 * 1000; //15 minutes
    private static final long REFRESH_TOKEN_EXPIRATION = 40 * 60 * 60 * 1000; // 48


    public  String genratetoken(String username , Boolean isAccessToken){

        long expiration = isAccessToken ? ACCESSTOKEN_EXPIRATION : REFRESH_TOKEN_EXPIRATION;

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))  // Set expiration correctly
                .signWith(getSecretkey())
                .compact();

    }

    public String getUsernameFromToken(String token){
        /*
        Traditionlayy way

        Claims claims = Jwts.parserBuiler() // Use the new parserBuilder() method
                .setSigningKey(key)  // Set the signing key (using SecretKey)
                .build()  // Build the parser
                .parseClaimsJws(token)  // Parse the token and return claims
                .getBody();
         */
        return getExtractAllCliams(token).getSubject() ;

    }

    private Claims getExtractAllCliams(String token) {
        return  Jwts.parser()
                .verifyWith(getSecretkey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    private SecretKey getSecretkey() {
       return  Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes());
    }

    public boolean validateToken(String token){
        return  true;
    }

}
