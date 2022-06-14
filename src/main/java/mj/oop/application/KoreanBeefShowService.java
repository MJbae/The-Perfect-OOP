package mj.oop.application;

import mj.oop.application.interfaces.ProductShowService;
import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class KoreanBeefShowService implements ProductShowService<KoreanBeef> {
    private final KoreanBeefRepository repository;

    public KoreanBeefShowService(KoreanBeefRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<KoreanBeef> showAll() {
        return repository.findAll();
    }

    @Override
    public KoreanBeef showBy(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(id.toString()));
    }
}
