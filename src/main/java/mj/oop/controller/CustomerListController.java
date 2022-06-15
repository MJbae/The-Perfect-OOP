package mj.oop.controller;

import mj.oop.application.CustomerShowService;
import mj.oop.application.interfaces.UserShowService;
import mj.oop.controller.dto.CustomerResponseData;
import mj.oop.controller.interfaces.UserListController;
import mj.oop.domain.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class CustomerListController implements UserListController<CustomerResponseData> {
    private final UserShowService<Customer> service;

    public CustomerListController(CustomerShowService service) {
        this.service = service;
    }

    @GetMapping
    @Override
    public List<CustomerResponseData> list() {
        return service.showAll().stream()
                .map(CustomerResponseData::from)
                .collect(Collectors.toList());
    }


}
