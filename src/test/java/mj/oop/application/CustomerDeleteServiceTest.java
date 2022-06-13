package mj.oop.application;


import mj.oop.application.interfaces.UserDeleteService;
import mj.oop.infra.CustomerRepository;
import mj.oop.infra.UserJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("CustomerDeleteService")
class CustomerDeleteServiceTest {
    private UserDeleteService service;
    private final CustomerRepository repository = mock(CustomerRepository.class);
    private final Long USER_ID = 1L;
    private final Long USER_ID_NOT_EXISTING = 10L;

    @BeforeEach
    void setUp() {
        service = new CustomerDeleteService(repository);
    }

    @Nested
    @DisplayName("deleteBy 메소드는")
    class Describe_deleteBy {
        abstract class ContextDeletingExisting {
            void withExisting() {
                service.deleteBy(USER_ID);
            }
        }

        abstract class ContextDeletingNotExisting {
            void withoutExisting() {
                service.deleteBy(USER_ID_NOT_EXISTING);
            }
        }

        @Nested
        @DisplayName("만약 존재하는 User를 삭제한다면")
        class Context_with_existing_user extends ContextDeletingExisting {
            @BeforeEach
            void setUp() {
                given(repository.existsById(USER_ID)).willReturn(Boolean.TRUE);
            }

            @Test
            @DisplayName("값을 반환하지 않는다")
            void it_returns_nothing() {
                withExisting();
            }
        }

        @Nested
        @DisplayName("만약 존재하지 않는 User를 삭제한다면")
        class Context_with_not_existing_user extends ContextDeletingNotExisting {
            @BeforeEach
            void setUp() {
                given(repository.existsById(USER_ID_NOT_EXISTING)).willReturn(Boolean.FALSE);
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
