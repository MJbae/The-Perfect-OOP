package mj.oop.application;


import mj.oop.application.interfaces.UserUpdateService;
import mj.oop.domain.entity.Customer;
import mj.oop.infra.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CustomerUpdateService implements UserUpdateService<Customer> {
    private final CustomerRepository repository;

    public CustomerUpdateService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer update(Long id, Customer user) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(id.toString());
        }

        Customer userUpdating = Customer.builder()
                .id(id)
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        return repository.save(userUpdating);
    }
}
