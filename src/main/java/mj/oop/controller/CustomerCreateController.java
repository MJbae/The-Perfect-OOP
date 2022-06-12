package mj.oop.controller;

import mj.oop.application.interfaces.UserCreateService;
import mj.oop.application.interfaces.UserShowService;
import mj.oop.controller.dto.UserRequestData;
import mj.oop.controller.dto.UserResponseData;
import mj.oop.controller.interfaces.UserCreateController;
import mj.oop.controller.interfaces.UserListController;
import mj.oop.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class CustomerCreateController implements UserCreateController {
    private final UserCreateService service;

    public CustomerCreateController(UserCreateService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public UserResponseData create(@RequestBody @Valid UserRequestData requestData) {
        User user = service.create(requestData.toEntity());
        return UserResponseData.from(user);
    }

}
