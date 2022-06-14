package mj.oop.controller.dto;

import lombok.Getter;
import mj.oop.controller.validator.Password;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public abstract class UserRequestData {
    @NotBlank
    private final String name;

    @Email
    @NotBlank
    private final String email;

    @Password
    private final String password;

    public UserRequestData(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
