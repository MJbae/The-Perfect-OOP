package mj.oop.controller;

import mj.oop.application.CustomerShowService;
import mj.oop.controller.dto.CustomerResponseData;
import mj.oop.controller.interfaces.UserDetailController;
import mj.oop.domain.entity.Customer;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class CustomerDetailController implements UserDetailController<CustomerResponseData> {
    private final CustomerShowService service;

    public CustomerDetailController(CustomerShowService service) {
        this.service = service;
    }


    @GetMapping("{id}")
    @Override
    public CustomerResponseData detail(@PathVariable Long id) {
        Customer user = service.showById(id);
        return CustomerResponseData.from(user);
    }

}
