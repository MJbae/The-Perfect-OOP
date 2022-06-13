package mj.oop.application;


import mj.oop.application.interfaces.UserCreateService;
import mj.oop.domain.entity.Customer;
import mj.oop.domain.entity.User;
import mj.oop.infra.CustomerRepository;
import mj.oop.infra.UserJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("CustomerCreateService")
class CustomerCreateServiceTest {
    private UserCreateService service;
    private final CustomerRepository repository = mock(CustomerRepository.class);
    private final Long USER_ID = 1L;
    private final String USER_NAME = "Test User";
    private final String USER_EMAIL = "hello@gmail.com";
    private final String USER_PASSWORD = "yahOo~!@12345";
    private Customer user;
    private Customer userWithoutId;


    @BeforeEach
    void setUp() {
        service = new CustomerCreateService(repository);
        user = Customer.builder()
                .id(USER_ID)
                .name(USER_NAME)
                .email(USER_EMAIL)
                .password(USER_PASSWORD)
                .build();
        userWithoutId = Customer.builder()
                .name(USER_NAME)
                .email(USER_EMAIL)
                .password(USER_PASSWORD)
                .build();
    }

    @Nested
    @DisplayName("create 메소드는")
    class Describe_create {
        private User subject() {
            return service.create(userWithoutId);
        }

        @BeforeEach
        void setUp() {
            given(repository.save(any(Customer.class))).willReturn(user);
        }

        @Test
        @DisplayName("매개변수로 전달한 값이 반영된 User를 반환한다")
        void it_returns_toy_reflecting_params() {
            assertThat(subject().getName()).isEqualTo(USER_NAME);
            assertThat(subject().getEmail()).isEqualTo(USER_EMAIL);
            assertThat(subject().getPassword()).isEqualTo(USER_PASSWORD);
        }
    }
}
