package mj.oop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProductResponseData {
    private Long id;

    private String name;

    private BigDecimal price;
}
