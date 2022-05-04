package com.apiplatform.bookstore.utils;

import com.apiplatform.bookstore.exceptions.AccessDeniedException;
import com.apiplatform.bookstore.models.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static final String secret = "^9jji$*&08U$ybusju*65";
    private static final long expiryDuration = 60 * 60;

    public String generateJwt(UserModel userModel) {

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        Claims claims = Jwts.claims().setIssuer(userModel.getId()).setIssuedAt(issuedAt).setExpiration(expiryAt);
        claims.put("emailid",userModel.getEmailId());
        claims.put("username",userModel.getUserName());
        return Jwts.builder().addClaims(claims).signWith(SignatureAlgorithm.HS256,secret).compact();
    }

    public Claims verifyJwt(String authorization) throws Exception {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
        } catch (Exception e) {
            throw  new AccessDeniedException("access denied");
        }
    }
}
