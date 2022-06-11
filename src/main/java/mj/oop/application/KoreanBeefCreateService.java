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
        return new KoreanBeef(1L, "세상에서 제일 맛있는 한우", new BigDecimal(1000), "1+");
    }
}
