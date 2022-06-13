package mj.oop.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mj.oop.domain.entity.KoreanBeef;

import java.math.BigDecimal;

@Getter
public class KoreanBeefResponseData extends ProductResponseData {
    private final String meatGrade;

    @JsonCreator
    public KoreanBeefResponseData(@JsonProperty("id") Long id, @JsonProperty("name") String name,
                                  @JsonProperty("price") BigDecimal price, @JsonProperty("meatGrade") String meatGrade) {
        super(id, name, price);
        this.meatGrade = meatGrade;
    }

    public static KoreanBeefResponseData from(KoreanBeef product) {
        return new KoreanBeefResponseData(product.id(), product.name(), product.price(), product.meatGrade());
    }
}
