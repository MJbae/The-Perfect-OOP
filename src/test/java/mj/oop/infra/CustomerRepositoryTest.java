package mj.oop.infra;

import mj.oop.domain.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("CustomerRepository")
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repository;


    private final Long USER_ID = 1L;
    private final Long USER_ID_NOT_EXISTING = 10L;
    private final String USER_NAME = "Test User";
    private final String USER_EMAIL = "hello@gmail.com";
    private final String USER_PASSWORD = "yahOo~!@12345";

    private Customer user;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        user = Customer.builder()
                .id(USER_ID)
                .name(USER_NAME)
                .email(USER_EMAIL)
                .password(USER_PASSWORD)
                .build();
    }

    @Nested
    @DisplayName("findAll 메소드는")
    class Describe_findAll {
        private List<Customer> subject() {
            return repository.findAll();
        }

        @Nested
        @DisplayName("만약 고객이 존재하지 않는다면")
        class Context_without_existing {
            @Test
            @DisplayName("비어 있는 List를 반환한다")
            void it_returns_empty_list() {
                assertThat(subject()).isEmpty();
            }
        }

        @Nested
        @DisplayName("만약 고객이 존재한다면")
        class Context_with_existing {
            @BeforeEach
            void setUp() {
                repository.save(user);
            }

            @Test
            @DisplayName("비어 있지 않은 List를 반환한다")
            void it_returns_not_empty_list() {
                assertThat(subject()).isNotEmpty();
            }
        }
    }

    @Nested
    @DisplayName("findById 메소드는")
    class Describe_findById {
        private Optional<Customer> subjectWithExistingId() {
            return repository.findById(USER_ID);
        }


        @Nested
        @DisplayName("존재하는 고객 아이디를 전달 받는다면")
        class Context_with_existing {
            @BeforeEach
            void setUp() {
                repository.save(user);
            }

            @Test
            @DisplayName("비어 있지 않은 값을 반환한다")
            void it_returns_not_empty() {
                assertThat(subjectWithExistingId()).isPresent();
            }
        }

        @Nested
        @DisplayName("만약 존재하지 않는 고객 아이디를 전달 받는다면")
        class Context_without_existing {
            private Optional<Customer> subjectWithNotExistingId() {
                return repository.findById(USER_ID_NOT_EXISTING);
            }

            @Test
            @DisplayName("빈 값을 반환한다")
            void it_returns_empty() {
                assertThat(subjectWithNotExistingId()).isNotPresent();
            }
        }
    }

}
