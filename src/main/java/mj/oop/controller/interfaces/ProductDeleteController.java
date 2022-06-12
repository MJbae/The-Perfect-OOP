package mj.oop.controller.interfaces;


import mj.oop.controller.KoreanBeefDeleteController;

/**
 * Product 타입 객체에 대한 삭제 조회 요청을 받는다
 * <p>
 * All Known Implementing Classes:
 * @see KoreanBeefDeleteController
 * </p>
 */
public interface ProductDeleteController {
    /**
     * 삭제 요청을 수신하여 관련 프로세스에 넘긴다. 처리결과를 반환하지 않는다.
     * <p>
     * @param id Request Path Parameter 전달된 Product Id
     * </p>
     */
    void delete(Long id);
}
