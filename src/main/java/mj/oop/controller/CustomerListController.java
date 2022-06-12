package mj.oop.controller;

import mj.oop.application.interfaces.UserShowService;
import mj.oop.controller.dto.UserResponseData;
import mj.oop.controller.interfaces.UserListController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class CustomerListController implements UserListController {
    private final UserShowService service;

    public CustomerListController(UserShowService service) {
        this.service = service;
    }

    @GetMapping
    @Override
    public List<UserResponseData> list() {
        return service.showAll().stream()
                .map(UserResponseData::from)
                .collect(Collectors.toList());
    }


}
