package mj.oop.application;

import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("KoreanBeefShowService")
class KoreanBeefShowServiceTest {
    private final KoreanBeefJpaRepository repository = mock(KoreanBeefJpaRepository.class);
    private KoreanBeefShowService service;
    private KoreanBeef product;

    private final String PRODUCT_NAME = "세상에서 제일 맛있는 한우";
    private final BigDecimal PRICE = new BigDecimal(1000);
    private final String MEAT_GRADE = "1+";
    private final Long PRODUCT_ID = 1L;

    @BeforeEach
    void setUp() {
        service = new KoreanBeefShowService(repository);

        product = KoreanBeef.builder()
                .id(PRODUCT_ID)
                .name(PRODUCT_NAME)
                .price(PRICE)
                .meatGrade(MEAT_GRADE)
                .build();
    }

    @Nested
    @DisplayName("showAll 메소드는")
    class Describe_showAll {
        private List<KoreanBeef> subject() {
            return service.showAll();
        }

        @Nested
        @DisplayName("만약 상품이 존재하지 않는다면")
        class Context_without_existing_product {
            @BeforeEach
            void setUp() {
                given(repository.findAll()).willReturn(List.of());
            }

            @Test
            @DisplayName("빈 리스트를 반환한다")
            void it_returns_empty_list() {
                assertThat(subject()).isEmpty();
            }
        }

        @Nested
        @DisplayName("만약 상품이 존재한다면")
        class Context_with_existing_product {
            @BeforeEach
            void setUp() {
                given(repository.findAll()).willReturn(List.of(product));
            }

            @Test
            @DisplayName("비어 있지 않은 리스트를 반환한다")
            void it_returns_not_empty_list() {
                assertThat(subject()).isNotEmpty();
            }
        }
    }
}
