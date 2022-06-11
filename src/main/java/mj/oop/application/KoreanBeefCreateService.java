package mj.oop.application;

import mj.oop.application.interfaces.ProductCreateService;
import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefJpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class KoreanBeefCreateService implements ProductCreateService<KoreanBeef> {
    private final KoreanBeefJpaRepository repository;

    public KoreanBeefCreateService(KoreanBeefJpaRepository repository) {
        this.repository = repository;
    }
    @Override
    public KoreanBeef create(KoreanBeef product) {
        return repository.save(product);
    }
}
