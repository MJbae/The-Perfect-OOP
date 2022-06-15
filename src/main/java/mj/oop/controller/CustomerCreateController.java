package mj.oop.controller;

import mj.oop.application.CustomerCreateService;
import mj.oop.application.interfaces.UserCreateService;
import mj.oop.controller.dto.CustomerRequestData;
import mj.oop.controller.dto.CustomerResponseData;
import mj.oop.controller.interfaces.UserCreateController;
import mj.oop.domain.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class CustomerCreateController implements UserCreateController<CustomerResponseData, CustomerRequestData> {
    private final UserCreateService<Customer> service;

    public CustomerCreateController(CustomerCreateService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public CustomerResponseData create(@RequestBody @Valid CustomerRequestData requestData) {
        Customer user = service.create(requestData.toEntity());
        return CustomerResponseData.from(user);
    }

}
