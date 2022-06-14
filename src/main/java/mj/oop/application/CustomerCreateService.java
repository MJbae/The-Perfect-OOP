package mj.oop.application;


import mj.oop.application.interfaces.UserCreateService;
import mj.oop.domain.entity.Customer;
import mj.oop.infra.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerCreateService implements UserCreateService<Customer> {
    private final CustomerRepository repository;

    public CustomerCreateService(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public Customer create(Customer user) {
        Customer userSaving = Customer.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        return repository.save(userSaving);
    }

}
