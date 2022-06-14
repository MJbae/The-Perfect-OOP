package mj.oop.application.interfaces;

import mj.oop.application.CustomerShowService;
import mj.oop.domain.entity.User;

import java.util.List;

/**
 * User 타입 조회에 대한 비지니스 로직을 처리한다
 * <p>
 * All Known Implementing Classes:\
 * @see CustomerShowService
 * </p>
 */
public interface UserShowService<T extends User> {
    /**
     * 모든 User 엔티티를 List 형태로 반환한다
     * <p>
     * @return User 엔티티를 내부 요소로 하는 List Collection
     * </p>
     */
    List<T> showAll();

    /**
     * 매개변수로 전달 받은 id에 해당하는 User 엔티티를 반환한다
     * <p>
     * @param id User 엔티티의 Id에 해당
     * @return User 엔티티
     * </p>
     */
    T showById(Long id);
}
