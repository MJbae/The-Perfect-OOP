package mj.oop.controller.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public abstract class ProductRequestData {
    @NotBlank
    private final String name;

    @NotNull
    private final BigDecimal price;

    public ProductRequestData(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
