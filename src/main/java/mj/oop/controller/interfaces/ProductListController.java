package mj.oop.controller.interfaces;


import mj.oop.controller.KoreanBeefListController;
import mj.oop.controller.dto.ProductResponseData;

import java.util.List;

/**
 * Product 타입을 상속하는 객체에 대한 목록 조회 요청을 받아서 처리결과를 응답으로 반환한다
 * <p>
 * All Known Implementing Classes:
 * @see KoreanBeefListController
 * </p>
 */
public interface ProductListController<T extends ProductResponseData> {
    /**
     * 목록 조회 요청에 따른 처리 결과를 List<ProductResponseData> 형태로 가공하여 반환한다
     * <p>
     * @return  목록 조회 요청에 대한 처리결과를 JSON 객체로 역직렬화하기 위한 객체
     * </p>
     */
    List<T> list();
}
