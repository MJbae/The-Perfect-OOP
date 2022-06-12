package mj.oop.application;


import mj.oop.application.interfaces.UserShowService;
import mj.oop.domain.entity.User;
import mj.oop.infra.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerShowService implements UserShowService {
    private final UserJpaRepository repository;

    public CustomerShowService(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> showAll() {
        return repository.findAll();
    }

    @Override
    public User showById(Long id) {
        return repository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(id.toString()));
    }

}
