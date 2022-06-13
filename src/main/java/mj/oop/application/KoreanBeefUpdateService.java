package mj.oop.application;

import mj.oop.application.interfaces.ProductUpdateService;
import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class KoreanBeefUpdateService implements ProductUpdateService<KoreanBeef> {
    private final KoreanBeefRepository repository;

    public KoreanBeefUpdateService(KoreanBeefRepository repository) {
        this.repository = repository;
    }

    @Override
    public KoreanBeef update(Long id, KoreanBeef product) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(id.toString());
        }

        KoreanBeef productUpdating = KoreanBeef.builder()
                .id(product.id())
                .name(product.name())
                .price(product.price())
                .meatGrade(product.meatGrade()).build();

        return repository.save(productUpdating);
    }
}
