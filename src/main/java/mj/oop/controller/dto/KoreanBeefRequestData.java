package mj.oop.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import mj.oop.domain.entity.KoreanBeef;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
public class KoreanBeefRequestData extends ProductRequestData {
    @NotBlank
    private final String meatGrade;

    @Builder
    @JsonCreator
    public KoreanBeefRequestData(@JsonProperty("name") String name, @JsonProperty("price") BigDecimal price,
                                 @JsonProperty("meatGrade") String meatGrade) {
        super(name, price);
        this.meatGrade = meatGrade;
    }

    public KoreanBeef toEntity() {
        return KoreanBeef.builder()
                .name(getName())
                .price(getPrice())
                .meatGrade(getMeatGrade()).build();
    }
}
