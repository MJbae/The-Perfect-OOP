package mj.oop.application;

import mj.oop.application.interfaces.ProductShowService;
import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("KoreanBeefShowService")
class KoreanBeefShowServiceTest {
    private final KoreanBeefJpaRepository repository = mock(KoreanBeefJpaRepository.class);
    private ProductShowService<KoreanBeef> service;
    private KoreanBeef product;

    private final String PRODUCT_NAME = "세상에서 제일 맛있는 한우";
    private final BigDecimal PRICE = new BigDecimal(1000);
    private final String MEAT_GRADE = "1+";
    private final Long PRODUCT_ID = 1L;
    private final Long PRODUCT_ID_NOT_EXISTING = 100L;

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

    @Nested
    @DisplayName("showBy 메소드는")
    class Describe_showBy {
        abstract class ContextShowingByExisting {
            KoreanBeef withExisting() {
                return service.showBy(PRODUCT_ID);
            }
        }

        abstract class ContextShowingByNotExisting {
            void withoutExisting() {
                service.showBy(PRODUCT_ID_NOT_EXISTING);
            }
        }

        @Nested
        @DisplayName("만약 존재하는 상품의 ID를 전달 받는다면")
        class Context_with_existing extends ContextShowingByExisting {
            @BeforeEach
            void setUp() {
                given(repository.findById(PRODUCT_ID)).willReturn(Optional.of(product));
            }

            @Test
            @DisplayName("전달 받은 Id에 해당하는 상품을 반환한다")
            void it_returns_product_having_id_equal_to_param() {
                assertThat(withExisting().getId()).isEqualTo(PRODUCT_ID);
            }
        }

        @Nested
        @DisplayName("만약 존재하지 않는 상품의 ID를 전달 받는다면")
        class Context_with_not_existing extends ContextShowingByNotExisting {
            @Test
            @DisplayName("예외를 발생시킨다")
            void it_throws_exception() {
                assertThatThrownBy(this::withoutExisting)
                        .isInstanceOf(NoSuchElementException.class);
            }

        }
    }
}
