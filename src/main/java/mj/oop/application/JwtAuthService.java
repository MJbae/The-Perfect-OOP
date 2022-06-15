package mj.oop.application;


import io.jsonwebtoken.Claims;
import mj.oop.application.interfaces.TokenAuthService;
import mj.oop.auth.JwtAuth;
import mj.oop.auth.interfaces.ClaimTokenAuth;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthService implements TokenAuthService {
    private final ClaimTokenAuth<Claims> auth;
    private final String JWT =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxIn0.aqbG22EmNECI69ctM6Jsas4SWOxalVlcgF05iujelq4";
    public JwtAuthService(JwtAuth auth) {
        this.auth = auth;
    }

    @Override
    public String login(String email, String password) {
        return JWT;
    }
}
