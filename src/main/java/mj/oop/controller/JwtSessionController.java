package mj.oop.controller;


import mj.oop.application.JwtAuthService;
import mj.oop.controller.dto.LoginRequestData;
import mj.oop.controller.dto.LoginResponseData;
import mj.oop.controller.interfaces.SessionController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtSessionController implements SessionController {
    private final JwtAuthService service;

    private final String JWT =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxIn0.aqbG22EmNECI69ctM6Jsas4SWOxalVlcgF05iujelq4";
    public JwtSessionController(JwtAuthService service) {
        this.service = service;
    }

    @PostMapping("/session")
    @Override
    public LoginResponseData login(@RequestBody LoginRequestData requestData) {
        return new LoginResponseData(JWT);
    }
}
