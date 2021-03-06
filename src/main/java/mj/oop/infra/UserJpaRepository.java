package mj.oop.infra;

import mj.oop.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * '사용자' 저장소 인터페이스
 */
@Repository
public interface UserJpaRepository<T extends User> extends CrudRepository<T, Long> {
    /**
     * 모든 사용자를 반환한다
     * <p>
     *
     * @return 사용자를 내부 요소로 하는 List
     * </p>
     */
    List<T> findAll();

    /**
     * id에 해당하는 사용자를 반환한다
     * <p>
     * @param id 사용자 id
     * @return Optional<User> 사용자
     * </p>
     */
    Optional<T> findById(Long id);

    /**
     * 사용자를 저장하고, 저장된 사용자를 반환한다
     * <p>
     * @param user 사용자
     * @return 사용자
     * </p>
     */
    T save(T user);


    /**
     * id에 해당하는 사용자를 삭제한다
     * <p>
     * @param id 사용자 id
     * </p>
     */
    void deleteById(Long id);

    /**
     * id에 해당하는 사용자 존재여부를 반환한다
     * <p>
     * @param id 사용자 id
     * @return 사용자 존재여부
     * </p>
     */
    boolean existsById(Long id);
}
