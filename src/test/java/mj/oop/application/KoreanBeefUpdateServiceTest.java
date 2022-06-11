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

@DisplayName("KoreanBeefUpdateService")
class KoreanBeefUpdateServiceTest {
    private final KoreanBeefJpaRepository repository = mock(KoreanBeefJpaRepository.class);
    private KoreanBeefUpdateService service;
    private KoreanBeef product;

    private final String PRODUCT_NAME = "세상에서 제일 맛있는 한우";
    private final BigDecimal PRICE = new BigDecimal(1000);
    private final String MEAT_GRADE = "1+";
    private final Long PRODUCT_ID = 1L;
    private final Long PRODUCT_ID_NOT_EXISTING = 100L;

    @BeforeEach
    void setUp() {
        service = new KoreanBeefUpdateService(repository);

        product = KoreanBeef.builder()
                .name(PRODUCT_NAME)
                .price(PRICE)
                .meatGrade(MEAT_GRADE)
                .build();
    }

    @Nested
    @DisplayName("update 메소드는")
    class Describe_update {
        abstract class ContextUpdatingExisting {
            KoreanBeef withExisting() {
                return service.update(PRODUCT_ID, product);
            }
        }

        abstract class ContextUpdatingNotExisting {
            void withoutExisting() {
                service.update(PRODUCT_ID_NOT_EXISTING, product);
            }
        }

        @Nested
        @DisplayName("만약 존재하는 상을 수정한다면")
        class Context_with_existing extends ContextUpdatingExisting {
            @BeforeEach
            void setUp() {
                given(repository.existsById(PRODUCT_ID)).willReturn(Boolean.TRUE);
                given(repository.save(any(KoreanBeef.class))).will(invocation -> {
                    KoreanBeef source = invocation.getArgument(0);
                    return KoreanBeef.builder()
                            .id(PRODUCT_ID)
                            .name(source.getName())
                            .price(source.getPrice())
                            .meatGrade(source.getMeatGrade())
                            .build();
                });
            }

            @Test
            @DisplayName("매개변수로 전달한 값을 Id로 가지고 있는 User를 반환한다")
            void it_returns_product_having_id_equal_to_param() {
                assertThat(withExisting().getId()).isEqualTo(PRODUCT_ID);
            }

            @Test
            @DisplayName("매개변수로 전달한 값이 반영된 한우 상품을 반환한다")
            void it_returns_product_reflecting_params() {
                assertThat(withExisting().getName()).isEqualTo(PRODUCT_NAME);
                assertThat(withExisting().getPrice()).isEqualTo(PRICE);
                assertThat(withExisting().getMeatGrade()).isEqualTo(MEAT_GRADE);
            }
        }
    }
}
