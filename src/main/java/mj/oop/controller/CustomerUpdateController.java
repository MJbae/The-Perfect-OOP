package mj.oop.controller;

import mj.oop.application.interfaces.UserUpdateService;
import mj.oop.controller.dto.UserRequestData;
import mj.oop.controller.dto.UserResponseData;
import mj.oop.controller.interfaces.UserUpdateController;
import mj.oop.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class CustomerUpdateController implements UserUpdateController {
    private final UserUpdateService service;

    public CustomerUpdateController(UserUpdateService service) {
        this.service = service;
    }

    @PatchMapping("{id}")
    @Override
    public UserResponseData update(@PathVariable Long id, @RequestBody @Valid UserRequestData requestData) {
        User user = service.update(id, requestData.toEntity());
        return UserResponseData.from(user);
    }

}
