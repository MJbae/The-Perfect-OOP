package mj.oop.application;

import mj.oop.application.interfaces.ProductDeleteService;
import mj.oop.infra.KoreanBeefJpaRepository;
import org.springframework.stereotype.Service;


@Service
public class KoreanBeefDeleteService implements ProductDeleteService {
    private final KoreanBeefJpaRepository repository;

    public KoreanBeefDeleteService(KoreanBeefJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteBy(Long id) {
    }
}
