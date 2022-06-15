package mj.oop.auth;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import mj.oop.auth.interfaces.ClaimTokenAuth;
import mj.oop.auth.interfaces.SecretKey;
import org.springframework.stereotype.Component;

@Component
public class JwtAuth implements ClaimTokenAuth<Claims> {
    private final SecretKey key;

    public JwtAuth(JwtKey key) {
        this.key = key;
    }

    @Override
    public String encode(Long id) {
        return Jwts.builder()
                .signWith(key.keyEncrypted())
                .claim("userId", id)
                .compact();
    }

    @Override
    public Claims decode(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key.keyEncrypted())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
