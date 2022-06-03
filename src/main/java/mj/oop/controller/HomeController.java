package mj.oop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final String WELCOME_MESSAGE = "Welcome to Shopping Mall API";

    @RequestMapping("/")
    public String welcomeMessage() {
        return WELCOME_MESSAGE;
    }
}
