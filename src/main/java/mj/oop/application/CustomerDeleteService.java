package mj.oop.application;


import mj.oop.application.interfaces.UserDeleteService;
import mj.oop.infra.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerDeleteService implements UserDeleteService {
    private final UserJpaRepository repository;

    public CustomerDeleteService(UserJpaRepository repository) {
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
