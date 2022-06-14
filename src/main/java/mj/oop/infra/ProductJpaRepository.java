package mj.oop.infra;

import mj.oop.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductJpaRepository<T extends Product> extends CrudRepository<T, Long> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T product);

    void deleteById(Long id);

    boolean existsById(Long id);
}
