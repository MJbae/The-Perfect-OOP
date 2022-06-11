package mj.oop.application.interfaces;

import mj.oop.domain.entity.Product;

import java.util.List;

/**
 * Product 타입을 상속하는 객체의 조회에 대한 비지니스 로직을 처리한다
 * <p>
 * All Known Implementing Classes:
 * </p>
 */
public interface ProductShowService<T extends Product> {
    /**
     * Product 타입 상속 객체를 List 형태로 반환한다
     * <p>
     * @return Product 타입 상속 객체를 내부 요소로 하는 List Collection
     * </p>
     */
    List<T> showAll();

    /**
     * 매개변수로 전달 받은 id에 해당하는 Product 타입 상속 객체를 반환한다
     * <p>
     * @param id Product 타입 상속 객체의 Id
     * @return Product 타입 상속 객체
     * </p>
     */
    T showBy(Long id);
}
