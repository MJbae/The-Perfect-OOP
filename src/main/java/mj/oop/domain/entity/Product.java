package mj.oop.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * '상품'에 대한 최상위 엔티티
 * <p>
 * All Known Extending Classes:
 * @see KoreanBeef
 * </p>
 */
@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Product {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    private BigDecimal price;

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

}
