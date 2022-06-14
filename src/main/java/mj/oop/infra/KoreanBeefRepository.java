package mj.oop.infra;

import mj.oop.domain.entity.KoreanBeef;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface KoreanBeefRepository extends ProductJpaRepository<KoreanBeef> {
    List<KoreanBeef> findAll();

    Optional<KoreanBeef> findById(Long id);

    KoreanBeef save(KoreanBeef product);

    void deleteById(Long id);

    boolean existsById(Long id);
}
