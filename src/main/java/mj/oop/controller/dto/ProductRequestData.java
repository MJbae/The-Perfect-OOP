package mj.oop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProductRequestData {
    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;
}
