package mj.oop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mj.oop.domain.entity.User;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseData {
    private Long id;

    private String name;

    private String email;

    private String password;


    public static UserResponseData from(User user) {
        return UserResponseData.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
