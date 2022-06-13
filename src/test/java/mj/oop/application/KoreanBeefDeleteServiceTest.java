package mj.oop.application;

import mj.oop.application.interfaces.ProductDeleteService;
import mj.oop.infra.KoreanBeefRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


@DisplayName("KoreanBeefDeleteService")
class KoreanBeefDeleteServiceTest {
    private final KoreanBeefRepository repository = mock(KoreanBeefRepository.class);
    private ProductDeleteService service;
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

        @Nested
        @DisplayName("만약 존재하지 않는 상품을 삭제한다면")
        class Context_with_not_existing_product extends ContextDeletingNotExisting {
            @BeforeEach
            void setUp() {
                given(repository.existsById(PRODUCT_ID_NOT_EXISTING)).willReturn(Boolean.FALSE);
            }

            @Test
            @DisplayName("예외를 발생시킨다")
            void it_throws_exception() {
                assertThatThrownBy(this::withoutExisting)
                        .isInstanceOf(NoSuchElementException.class);
            }
        }
    }
}
