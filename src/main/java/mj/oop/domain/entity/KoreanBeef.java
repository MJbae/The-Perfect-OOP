package mj.oop.domain.entity;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@DiscriminatorValue("KoreanBeef")
public class KoreanBeef extends Product {
    private String meatGrade;

    @Builder
    public KoreanBeef(Long id, String name, BigDecimal price, String meatGrade) {
        super(id, name, price);
        this.meatGrade = meatGrade;
    }

    @Builder
    public KoreanBeef(String name, BigDecimal price, String meatGrade) {
        super(name, price);
        this.meatGrade = meatGrade;
    }

    public String meatGrade() {
        return meatGrade;
    }
}
