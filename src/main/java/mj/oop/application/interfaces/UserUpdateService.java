package mj.oop.application.interfaces;

import mj.oop.application.CustomerUpdateService;
import mj.oop.domain.entity.User;

/**
 * 사용자 정보 수정 관련 비지니스 로직을 처리한다
 * <p>
 * All Known Implementing Classes:
 * @see CustomerUpdateService
 * </p>
 */
public interface UserUpdateService<T extends User> {
    /**
     * 매개변수로 전달 받은 id에 해당하는 User 엔티티를 반영하여 수정된 User 엔티티를 반환한다
     * <p>
     * @param id User 엔티티의 Id에 해당
     * @return 수정된 User 엔티티
     * </p>
     */
    T update(Long id, T user);
}
