package mj.oop.controller.dto;

import lombok.Getter;


@Getter
public class UserResponseData {
    private final Long id;

    private final String name;

    private final String email;

    private final String password;

    public UserResponseData(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
