package mj.oop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mj.oop.controller.validator.Password;
import mj.oop.domain.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestData {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Password
    private String password;


    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }


}
