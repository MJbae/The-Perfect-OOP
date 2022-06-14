package mj.oop.application;

import mj.oop.application.interfaces.ProductDeleteService;
import mj.oop.infra.KoreanBeefRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;


@Service
@Transactional
public class KoreanBeefDeleteService implements ProductDeleteService {
    private final KoreanBeefRepository repository;

    public KoreanBeefDeleteService(KoreanBeefRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteBy(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(id.toString());
        }

        repository.deleteById(id);
    }
}
