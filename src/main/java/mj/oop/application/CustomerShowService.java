package mj.oop.application;


import mj.oop.application.interfaces.UserShowService;
import mj.oop.domain.entity.Customer;
import mj.oop.infra.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CustomerShowService implements UserShowService<Customer> {
    private final CustomerRepository repository;

    public CustomerShowService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> showAll() {
        return repository.findAll();
    }

    @Override
    public Customer showById(Long id) {
        return repository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(id.toString()));
    }

}
