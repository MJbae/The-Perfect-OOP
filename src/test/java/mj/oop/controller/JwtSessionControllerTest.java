package mj.oop.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mj.oop.application.JwtAuthService;
import mj.oop.controller.dto.LoginRequestData;
import mj.oop.domain.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(JwtSessionController.class)
@DisplayName("JwtSessionController")
class JwtSessionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private JwtAuthService authService;

    private Customer user;
    private final String EMAIL = "test@gmail.com";
    private final String PASSWORD = "test0012300";
    private final Long USER_ID = 1L;
    private final String CUSTOMER_GRADE = "A+";
    private final String JWT =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxIn0.aqbG22EmNECI69ctM6Jsas4SWOxalVlcgF05iujelq4";

    private LoginRequestData requestData;

    @Nested
    @DisplayName("login 메소드는")
    class Describe_login {

        @Nested
        @DisplayName("동일한 비밀번호와 존재하는 이메일이 담긴 사용자 정보를 전달받으면")
        class Context_when_valid_auth_data {

            @BeforeEach
            void setUp() {
                user = Customer.builder()
                        .id(USER_ID)
                        .email(EMAIL)
                        .password(PASSWORD)
                        .customerGrade(CUSTOMER_GRADE)
                        .build();
                requestData = LoginRequestData.builder()
                        .email(EMAIL)
                        .password(PASSWORD)
                        .build();

                given(authService.login(requestData.getEmail(), requestData.getPassword())).willReturn(JWT);
            }

            @Test
            @DisplayName("HTTP Status Code 200을 응답한다")
            void it_responses_200_ok() throws Exception {
                mockMvc.perform(post("/session")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonFrom(requestData)))
                        .andExpect(status().isOk());
            }
        }
    }

    private String jsonFrom(LoginRequestData requestData) throws JsonProcessingException {
        return objectMapper.writeValueAsString(requestData);
    }
}
