package mj.oop.controller.dto;

import java.math.BigDecimal;

public class KoreanBeefResponseData extends ProductResponseData {
    private final String meatGrade;

    public KoreanBeefResponseData(Long id, String name, BigDecimal price, String meatGrade) {
        super(id, name, price);
        this.meatGrade = meatGrade;
    }
}
