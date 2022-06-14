package mj.oop.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import mj.oop.application.CustomerShowService;
import mj.oop.application.interfaces.UserShowService;
import mj.oop.domain.entity.Customer;
import mj.oop.domain.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(CustomerDetailController.class)
@DisplayName("CustomerDetailController")
class CustomerDetailControllerTest {
    @MockBean
    private CustomerShowService service;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private final Long USER_ID = 1L;
    private final Long USER_ID_NOT_EXISTING = 10L;
    private final String USER_NAME = "Test User";
    private final String USER_EMAIL = "hello@gmail.com";
    private final String USER_PASSWORD = "yahOo~!@12345";
    private final String CUSTOMER_GRADE = "A+";
    private Customer user;

    @BeforeEach
    void setUp() {
        user = Customer.builder()
                .id(USER_ID)
                .name(USER_NAME)
                .email(USER_EMAIL)
                .password(USER_PASSWORD)
                .customerGrade(CUSTOMER_GRADE)
                .build();
    }

    @Nested
    @DisplayName("detail 메소드는")
    class Describe_detail {
        @Nested
        @DisplayName("유효한 매개변수를 전달 받는다면")
        class Context_with_valid_param {
            @BeforeEach
            void setUp() {
                given(service.showById(USER_ID)).willReturn(user);
            }

            @Test
            @DisplayName("HTTP Status Code 200 OK 응답한다")
            void it_responds_with_200_ok() throws Exception {
                mockMvc.perform(get("/users/" + USER_ID))
                        .andExpect(status().isOk());
            }
        }

        @Nested
        @DisplayName("만약 존재하지 않는 ID를 매개변수로 전달 받는다면")
        class Context_with_invalid_param {
            @BeforeEach
            void setUp() {
                given(service.showById(USER_ID_NOT_EXISTING))
                        .willThrow(new NoSuchElementException(USER_ID_NOT_EXISTING.toString()));
            }

            @Test
            @DisplayName("HTTP Status Code 404 NOT FOUND 응답한다")
            void it_responds_with_404() throws Exception {
                mockMvc.perform(get("/users/" + USER_ID_NOT_EXISTING))
                        .andExpect(status().isNotFound());
            }

        }
    }
}
