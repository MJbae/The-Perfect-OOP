package mj.oop.controller.interfaces;


import mj.oop.controller.KoreanBeefCreateController;
import mj.oop.controller.dto.ProductRequestData;
import mj.oop.controller.dto.ProductResponseData;

/**
 * Product 타입을 상속하는 객체에 대한 생성 요청을 받아서 처리결과를 응답으로 반환한다
 * <p>
 * All Known Implementing Classes:
 * @see KoreanBeefCreateController
 * </p>
 */
public interface ProductCreateController<T extends ProductResponseData, T2 extends ProductRequestData> {
    /**
     * 생성 요청에 따른 처리 결과를 ProductResponseData 타입으로 가공하여 반환한다
     * <p>
     * @param requestDto Request Body로 전달된 JSON 객체를 직렬화하여 받기 위한 객체
     * @return 생성 요청에 대한 처리결과를 JSON 객체로 역직렬화하기 위한 객체
     * </p>
     */
    T create(T2 requestDto);
}
