package mj.oop.infra;

import mj.oop.domain.entity.KoreanBeef;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("JpaKoreanBeefRepository")
class JpaKoreanBeefRepositoryTest {
    @Autowired
    private JpaKoreanBeefRepository repository;

    private final String PRODUCT_NAME = "세상에서 제일 맛있는 한우";
    private final BigDecimal PRICE = new BigDecimal(1000);
    private final String MEAT_GRADE = "1+";

    private KoreanBeef product;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        product = KoreanBeef.builder()
                .name(PRODUCT_NAME)
                .price(PRICE)
                .meatGrade(MEAT_GRADE)
                .build();
    }

    @Nested
    @DisplayName("findAll 메소드는")
    class Describe_findAll {
        private List<KoreanBeef> subject() {
            return repository.findAll();
        }

        @Nested
        @DisplayName("만약 상품이 존재하지 않는다면")
        class Context_without_existing_product {
            @Test
            @DisplayName("비어 있는 List를 반환한다")
            void it_returns_empty_list() {
                assertThat(subject()).isEmpty();
            }
        }

        @Nested
        @DisplayName("만약 상품이 존재한다면")
        class Context_with_existing_product {
            @BeforeEach
            void setUp() {
                repository.save(product);
            }

            @Test
            @DisplayName("비어 있지 않은 List를 반환한다")
            void it_returns_not_empty_list() {
                assertThat(subject()).isNotEmpty();
            }
        }
    }

}
