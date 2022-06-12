package mj.oop.application.interfaces;

import mj.oop.application.KoreanBeefUpdateService;
import mj.oop.domain.entity.Product;

/**
 * Product 타입을 상속하는 객체의 수정에 대한 비지니스 로직을 처리한다
 * <p>
 * All Known Implementing Classes:
 * @see KoreanBeefUpdateService
 * </p>
 */
public interface ProductUpdateService<T extends Product> {
    /**
     * Product 타입을 상속하는 객체 수정하고, 수정된 객체를 반환한다.
     * <p>
     * @param id      Product 타입 객체의 Id
     * @param product Product 타입 객체
     * @return Product 타입 객체
     * </p>
     */
    T update(Long id, T product);
}
