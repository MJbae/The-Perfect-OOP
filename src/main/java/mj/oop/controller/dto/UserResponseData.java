package mj.oop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mj.oop.domain.entity.User;


@Getter
@Builder
@NoArgsConstructor
public class UserResponseData {
    private Long id;

    private String name;

    private String email;

    private String password;

    public UserResponseData(Long id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public static UserResponseData from(User user) {
        return UserResponseData.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
