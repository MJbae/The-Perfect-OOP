package mj.oop.application;


import mj.oop.application.interfaces.UserDeleteService;
import mj.oop.domain.entity.Customer;
import mj.oop.infra.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerDeleteService implements UserDeleteService<Customer> {
    private final CustomerRepository repository;

    public CustomerDeleteService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteBy(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(id.toString());
        }

        repository.deleteById(id);
    }
}
