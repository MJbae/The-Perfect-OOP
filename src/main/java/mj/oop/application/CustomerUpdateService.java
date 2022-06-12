package mj.oop.application;


import mj.oop.application.interfaces.UserUpdateService;
import mj.oop.domain.entity.User;
import mj.oop.infra.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerUpdateService implements UserUpdateService {
    private final UserJpaRepository repository;

    public CustomerUpdateService(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public User update(Long id, User user) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(id.toString());
        }

        User userUpdating = User.builder()
                .id(id)
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        return repository.save(userUpdating);
    }
}
