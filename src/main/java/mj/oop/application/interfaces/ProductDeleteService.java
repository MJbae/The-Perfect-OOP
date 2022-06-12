package mj.oop.application.interfaces;

import mj.oop.application.KoreanBeefDeleteService;


/**
 * Product 타입 객체의 삭제에 대한 비지니스 로직을 처리한다
 * <p>
 * All Known Implementing Classes:
 * @see KoreanBeefDeleteService
 * </p>
 */
public interface ProductDeleteService {
    /**
     * 매개변수로 전달 받은 id에 해당하는 Product 타입 객체를 삭제한다
     * <p>
     * @param id Product 타입 상속 객체의 Id
     * </p>
     */
    void deleteBy(Long id);
}
