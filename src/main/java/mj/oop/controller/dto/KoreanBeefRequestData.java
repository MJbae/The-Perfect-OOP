package mj.oop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mj.oop.domain.entity.KoreanBeef;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KoreanBeefRequestData extends ProductRequestData {
    @NotBlank
    private String meatGrade;

    @Builder
    public KoreanBeefRequestData(String name, BigDecimal price, String meatGrade) {
        super(name, price);
        this.meatGrade = meatGrade;
    }
}
