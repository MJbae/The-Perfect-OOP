package mj.oop.controller.interfaces;


import mj.oop.controller.KoreanBeefDetailController;
import mj.oop.controller.dto.ProductResponseData;

/**
 * Product 타입을 상속하는 객체에 대한 상세 조회 요청을 받아서 처리결과를 응답으로 반환한다
 * <p>
 * All Known Implementing Classes:
 * @see KoreanBeefDetailController
 * </p>
 */
public interface ProductDetailController<T extends ProductResponseData> {
    /**
     * 상세 조회 요청에 따른 처리 결과를 ProductResponseData 타입으로 가공하여 반환한다
     * <p>
     * @param id Request Path Parameter 전달된 Product Id
     * @return 상세 조회 요청에 대한 처리결과를 JSON 객체로 역직렬화하기 위한 객체
     * </p>
     */
    T detail(Long id);
}
