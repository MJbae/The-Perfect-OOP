package mj.oop.application;

import mj.oop.application.interfaces.ProductShowService;
import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefJpaRepository;

import java.util.List;

public class KoreanBeefShowService implements ProductShowService<KoreanBeef> {
    private final KoreanBeefJpaRepository repository;

    public KoreanBeefShowService(KoreanBeefJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<KoreanBeef> showAll() {
        return repository.findAll();
    }
}
