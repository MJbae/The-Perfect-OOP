package mj.oop.application;

import mj.oop.application.interfaces.ProductCreateService;
import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class KoreanBeefCreateService implements ProductCreateService<KoreanBeef> {
    private final KoreanBeefRepository repository;

    public KoreanBeefCreateService(KoreanBeefRepository repository) {
        this.repository = repository;
    }
    @Override
    public KoreanBeef create(KoreanBeef product) {
        return repository.save(product);
    }
}
