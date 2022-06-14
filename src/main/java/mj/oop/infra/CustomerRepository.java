package mj.oop.infra;

import mj.oop.domain.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * '고객' 저장소 인터페이스
 */
@Repository
public interface CustomerRepository extends UserJpaRepository<Customer> {
    /**
     * 모든 고객을 반환한다
     * <p>
     *
     * @return 고객을 내부 요소로 하는 List
     * </p>
     */
    List<Customer> findAll();

    /**
     * id에 해당하는 고객을 반환한다
     * <p>
     * @param id 고객 id
     * @return 고객
     * </p>
     */
    Optional<Customer> findById(Long id);

    /**
     * 고객을 저장하고, 저장된 고객을 반환한다
     * <p>
     * @param user 고객
     * @return 고객
     * </p>
     */
    Customer save(Customer user);


    /**
     * id에 해당하는 고객을 삭제한다
     * <p>
     * @param id 고객 id
     * </p>
     */
    void deleteById(Long id);

    /**
     * id에 해당하는 고객 존재여부를 반환한다
     * <p>
     * @param id 고객 id
     * @return 고객 존재여부
     * </p>
     */
    boolean existsById(Long id);
}
