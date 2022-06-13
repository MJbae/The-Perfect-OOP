package mj.oop.infra;

import mj.oop.domain.entity.KoreanBeef;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface KoreanBeefJpaRepository extends ProductJpaRepository<KoreanBeef> {
    List<KoreanBeef> findAll();

    Optional<KoreanBeef> findById(Long id);

    KoreanBeef save(KoreanBeef product);

    void delete(KoreanBeef product);

    boolean existsById(Long id);
}
