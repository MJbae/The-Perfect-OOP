package mj.oop.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mj.oop.application.CustomerUpdateService;
import mj.oop.controller.dto.CustomerRequestData;
import mj.oop.controller.dto.UserRequestData;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(CustomerUpdateController.class)
@DisplayName("CustomerUpdateController")
class CustomerUpdateControllerTest {
    @MockBean
    private CustomerUpdateService service;
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
    private Customer userWithoutId;

    @Nested
    @DisplayName("patch 메소드는")
    class Describe_patch {
        @Nested
        @DisplayName("유효한 매개변수를 전달 받는다면")
        class Context_with_valid_param {
            @BeforeEach
            void setUp() {
                user = Customer.builder()
                        .id(USER_ID)
                        .name(USER_NAME + "UPDATED")
                        .email(USER_EMAIL)
                        .password(USER_PASSWORD)
                        .customerGrade(CUSTOMER_GRADE)
                        .build();
                userWithoutId = Customer.builder()
                        .name(USER_NAME + "UPDATED")
                        .email(USER_EMAIL)
                        .password(USER_PASSWORD)
                        .customerGrade(CUSTOMER_GRADE)
                        .build();
                given(service.update(eq(USER_ID), any(Customer.class))).willReturn(user);
            }

            @Test
            @DisplayName("HTTP Status Code 200 OK 응답한다")
            void it_responds_with_200_ok() throws Exception {
                mockMvc.perform(patch("/users/" + USER_ID)
                                .content(jsonFrom(userWithoutId))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
            }
        }

        @Nested
        @DisplayName("만약 존재하지 않는 ID를 매개변수로 전달 받는다면")
        class Context_without_existing_user {
            @BeforeEach
            void setUp() {
                userWithoutId = Customer.builder()
                        .name(USER_NAME)
                        .email(USER_EMAIL)
                        .password(USER_PASSWORD)
                        .customerGrade(CUSTOMER_GRADE)
                        .build();
                given(service.update(eq(USER_ID_NOT_EXISTING), any(Customer.class)))
                        .willThrow(new NoSuchElementException(USER_ID_NOT_EXISTING.toString()));
            }

            @Test
            @DisplayName("HTTP Status Code 404 NOT FOUND 응답한다")
            void it_responds_with_404() throws Exception {
                mockMvc.perform(patch("/users/" + USER_ID_NOT_EXISTING)
                                .content(jsonFrom(userWithoutId))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound());
            }
        }

        @Nested
        @DisplayName("유효하지 않은 RequestBody를 전달 받는다면")
        class Context_with_invalid_request_body {
            @BeforeEach
            void setUp() {
                user = Customer.builder()
                        .id(USER_ID)
                        .name("")
                        .email(USER_EMAIL)
                        .password(USER_PASSWORD)
                        .customerGrade(CUSTOMER_GRADE)
                        .build();
                userWithoutId = Customer.builder()
                        .name("")
                        .email(USER_EMAIL)
                        .password(USER_PASSWORD)
                        .customerGrade(CUSTOMER_GRADE)
                        .build();
                given(service.update(eq(USER_ID), any(Customer.class))).willReturn(user);
            }

            @Test
            @DisplayName("HTTP Status Code 400 BAD REQUEST 응답한다")
            void it_responds_with_400() throws Exception {
                mockMvc.perform(patch("/users/" + USER_ID)
                                .content(jsonFrom(userWithoutId))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());

            }
        }
    }

    private String jsonFrom(Customer user) throws JsonProcessingException {
        CustomerRequestData requestData = CustomerRequestData.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .customerGrade(user.getCustomerGrade())
                .build();

        return objectMapper.writeValueAsString(requestData);
    }
}
