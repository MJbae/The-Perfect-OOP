package mj.oop.application.interfaces;

import mj.oop.application.KoreanBeefCreateService;
import mj.oop.domain.entity.Product;

/**
 * Product 타입을 상속하는 객체의 생성에 대한 비지니스 로직을 처리한다
 * <p>
 * All Known Implementing Classes:
 * @see KoreanBeefCreateService
 * </p>
 */
public interface ProductCreateService<T extends Product> {
    /**
     * Product 타입을 상속하는 객체 생성하고, 생성된 객체를 반환한다.
     * <p>
     * @param product Product 타입을 상속하는 객체
     * @return Product 타입을 상속하는 객체
     * </p>
     */
    T create(T product);
}
