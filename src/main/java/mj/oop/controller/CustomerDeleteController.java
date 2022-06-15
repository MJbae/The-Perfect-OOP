package mj.oop.controller;

import mj.oop.application.CustomerDeleteService;
import mj.oop.application.interfaces.UserDeleteService;
import mj.oop.controller.interfaces.UserDeleteController;
import mj.oop.domain.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class CustomerDeleteController implements UserDeleteController {
    private final UserDeleteService<Customer> service;

    public CustomerDeleteController(CustomerDeleteService service) {
        this.service = service;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void delete(@PathVariable Long id) {
        service.deleteBy(id);
    }
}
