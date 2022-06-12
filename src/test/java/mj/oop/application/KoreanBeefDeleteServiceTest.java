package mj.oop.application;

import mj.oop.application.interfaces.ProductDeleteService;
import mj.oop.domain.entity.KoreanBeef;
import mj.oop.infra.KoreanBeefJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


@DisplayName("KoreanBeefDeleteService")
class KoreanBeefDeleteServiceTest {
    private final KoreanBeefJpaRepository repository = mock(KoreanBeefJpaRepository.class);
    private ProductDeleteService service;
    private KoreanBeef product;

    private final String PRODUCT_NAME = "세상에서 제일 맛있는 한우";
    private final BigDecimal PRICE = new BigDecimal(1000);
    private final String MEAT_GRADE = "1+";
    private final Long PRODUCT_ID = 1L;
    private final Long PRODUCT_ID_NOT_EXISTING = 100L;

    @BeforeEach
    void setUp() {
        service = new KoreanBeefDeleteService(repository);
    }

    @Nested
    @DisplayName("deleteBy 메소드는")
    class Describe_deleteBy {
        abstract class ContextDeletingExisting {
            void withExisting() {
                service.deleteBy(PRODUCT_ID);
            }
        }

        abstract class ContextDeletingNotExisting {
            void withoutExisting() {
                service.deleteBy(PRODUCT_ID_NOT_EXISTING);
            }
        }

        @Nested
        @DisplayName("만약 존재하는 상품을 삭제한다면")
        class Context_with_existing_product extends ContextDeletingExisting {
            @BeforeEach
            void setUp() {
                given(repository.existsById(PRODUCT_ID)).willReturn(Boolean.TRUE);
            }

            @Test
            @DisplayName("값을 반환하지 않는다")
            void it_returns_nothing() {
                withExisting();
            }
        }
    }
}
