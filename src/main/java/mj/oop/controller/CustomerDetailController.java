package mj.oop.controller;

import mj.oop.application.interfaces.UserShowService;
import mj.oop.controller.dto.UserResponseData;
import mj.oop.controller.interfaces.UserDetailController;
import mj.oop.controller.interfaces.UserListController;
import mj.oop.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class CustomerDetailController implements UserDetailController {
    private final UserShowService service;

    public CustomerDetailController(UserShowService service) {
        this.service = service;
    }


    @GetMapping("{id}")
    @Override
    public UserResponseData detail(@PathVariable Long id) {
        User user = service.showById(id);
        return UserResponseData.from(user);
    }

}
