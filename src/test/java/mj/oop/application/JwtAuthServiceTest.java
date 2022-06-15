package mj.oop.application;

import mj.oop.auth.JwtAuth;
import mj.oop.auth.JwtKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("JwtAuthService")
class JwtAuthServiceTest {
    private JwtAuthService service;

    private final String SECRET_STRING = "12345678901234567890123456789010";
    private final JwtKey key = new JwtKey(SECRET_STRING);
    private final JwtAuth auth = new JwtAuth(key);
    private final String JWT =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxIn0.aqbG22EmNECI69ctM6Jsas4SWOxalVlcgF05iujelq4";
    private final String USER_EMAIL = "hello@gmail.com";
    private final String USER_PASSWORD = "yahOo~!@12345";

    @BeforeEach
    void setUp() {
        service = new JwtAuthService(auth);
    }

    @Nested
    @DisplayName("login 메소드는")
    class Describe_login {

        @DataJpaTest
        @Nested
        @DisplayName("유효한 User Entity를 전달 받으면")
        class Context_with_valid_user_entity {

            @Test
            @DisplayName("문자열 타입의 토큰을 반환한다.")
            void it_returns_string_token() {
                String token = service.login(USER_EMAIL, USER_PASSWORD);

                assertThat(token).isInstanceOf(String.class);
                assertThat(token).isEqualTo(JWT);
            }
        }
    }
}
