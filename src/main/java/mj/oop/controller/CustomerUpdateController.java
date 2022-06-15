package mj.oop.controller;

import mj.oop.application.CustomerUpdateService;
import mj.oop.application.interfaces.UserUpdateService;
import mj.oop.controller.dto.CustomerRequestData;
import mj.oop.controller.dto.CustomerResponseData;
import mj.oop.controller.interfaces.UserUpdateController;
import mj.oop.domain.entity.Customer;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class CustomerUpdateController implements UserUpdateController<CustomerResponseData, CustomerRequestData> {
    private final UserUpdateService<Customer> service;

    public CustomerUpdateController(CustomerUpdateService service) {
        this.service = service;
    }

    @PatchMapping("{id}")
    @Override
    public CustomerResponseData update(@PathVariable Long id, @RequestBody @Valid CustomerRequestData requestData) {
        Customer user = service.update(id, requestData.toEntity());
        return CustomerResponseData.from(user);
    }

}
