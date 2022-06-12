package mj.oop.application;


import mj.oop.application.interfaces.UserCreateService;
import mj.oop.domain.entity.User;
import mj.oop.infra.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCreateService implements UserCreateService {
    private final UserJpaRepository repository;

    public CustomerCreateService(UserJpaRepository repository) {
        this.repository = repository;
    }


    @Override
    public User create(User user) {
        User userSaving = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        return repository.save(userSaving);
    }

}
