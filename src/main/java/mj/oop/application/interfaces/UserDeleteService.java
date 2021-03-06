package mj.oop.application.interfaces;


import mj.oop.application.CustomerDeleteService;
import mj.oop.domain.entity.User;

/**
 * User 삭제에 대한 비지니스 로직을 처리한다
 * <p>
 * All Known Implementing Classes:
 * @see CustomerDeleteService
 * </p>
 */
public interface UserDeleteService<T extends User> {
    /**
     * 매개변수로 전달 받은 id에 해당하는 User를 삭제한다
     * <p>
     * @param id User 엔티티의 Id에 해당
     * </p>
     */
    void deleteBy(Long id);
}
