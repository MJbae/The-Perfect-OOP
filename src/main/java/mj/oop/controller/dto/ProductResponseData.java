package mj.oop.controller.dto;

import java.math.BigDecimal;

public abstract class ProductResponseData {
    private final Long id;

    private final String name;

    private final BigDecimal price;

    public ProductResponseData(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
