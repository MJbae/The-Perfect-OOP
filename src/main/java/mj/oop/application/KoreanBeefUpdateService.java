package mj.oop.application;

import mj.oop.application.interfaces.ProductUpdateService;
import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefJpaRepository;

import java.util.NoSuchElementException;

public class KoreanBeefUpdateService implements ProductUpdateService<KoreanBeef> {
    private final KoreanBeefJpaRepository repository;

    public KoreanBeefUpdateService(KoreanBeefJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public KoreanBeef update(Long id, KoreanBeef product) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(id.toString());
        }

        KoreanBeef productUpdating = KoreanBeef.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .meatGrade(product.getMeatGrade()).build();

        return repository.save(productUpdating);
    }
}
