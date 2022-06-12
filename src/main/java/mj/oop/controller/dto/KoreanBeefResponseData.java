package mj.oop.controller.dto;

import mj.oop.domain.entity.KoreanBeef;

import java.math.BigDecimal;

public class KoreanBeefResponseData extends ProductResponseData {
    private final String meatGrade;

    public KoreanBeefResponseData(Long id, String name, BigDecimal price, String meatGrade) {
        super(id, name, price);
        this.meatGrade = meatGrade;
    }

    public static KoreanBeefResponseData from(KoreanBeef product) {
        return new KoreanBeefResponseData(product.getId(), product.getName(), product.getPrice(), product.getMeatGrade());
    }
}
