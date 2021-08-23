package com.morelllcrm.security;

import com.morelllcrm.entities.Users;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static com.morelllcrm.security.SecurityConstants.EXPIRATION_TIME;
import static com.morelllcrm.security.SecurityConstants.SECRET;

@Component
public class JwtTokenProvider {

//    generating the token
    public String generateToken(Authentication authentication) {
        Users user = (Users) authentication.getPrincipal();

        Date currentDate = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(currentDate.getTime() + EXPIRATION_TIME);

        String userId =  Long.toString(user.getId());

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getEmailId());
        claims.put("fullName", user.getFirstName()+user.getLastName());
        return Jwts.builder().setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(currentDate)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

//    validating the token
    public Boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        }catch (SignatureException exception){
            System.out.print("Invalid JWT signature");
        }catch (MalformedJwtException malformedJwtException){
            System.out.print("Invalid Jwt token");
        }catch (ExpiredJwtException e){
            System.out.print("Expired Jwt token");
        }catch (UnsupportedJwtException malformedJwtException){
            System.out.print("Unsupported Jwt token");
        }catch (IllegalArgumentException malformedJwtException){
            System.out.print("Jwt claims is empty");
        }
        return false;
    }

//    get user id from the token
    public long getUserIdFromJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        Date name = claims.getExpiration();
        String id = claims.get("id").toString();
        return Long.parseLong(id);
    }


}

