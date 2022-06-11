package mj.oop.application;

import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("KoreanBeefCreateService")
class KoreanBeefCreateServiceTest {
    private final KoreanBeefJpaRepository repository = mock(KoreanBeefJpaRepository.class);
    private KoreanBeefCreateService service;
    private KoreanBeef productWithoutId;
    private KoreanBeef product;

    private final String PRODUCT_NAME = "세상에서 제일 맛있는 한우";
    private final BigDecimal PRICE = new BigDecimal(1000);
    private final String MEAT_GRADE = "1+";
    private final Long PRODUCT_ID = 1L;

    @BeforeEach
    void setUp() {
        service = new KoreanBeefCreateService(repository);

        productWithoutId = KoreanBeef.builder()
                .name(PRODUCT_NAME)
                .price(PRICE)
                .meatGrade(MEAT_GRADE)
                .build();

        product = KoreanBeef.builder()
                .id(PRODUCT_ID)
                .name(PRODUCT_NAME)
                .price(PRICE)
                .meatGrade(MEAT_GRADE)
                .build();
    }

    @Nested
    @DisplayName("create 메소드는")
    class Describe_create {
        private KoreanBeef subject() {
            return service.create(productWithoutId);
        }

        @BeforeEach
        void setUp() {
            given(repository.save(any(KoreanBeef.class))).willReturn(product);
        }

        @Test
        @DisplayName("매개변수로 전달한 값이 반영된 한우 상품 엔티티를 반환한다")
        void it_returns_product_reflecting_params() {
            assertThat(subject().getName()).isEqualTo(PRODUCT_NAME);
            assertThat(subject().getPrice()).isEqualTo(PRICE);
            assertThat(subject().getMeatGrade()).isEqualTo(MEAT_GRADE);
        }
    }
}
