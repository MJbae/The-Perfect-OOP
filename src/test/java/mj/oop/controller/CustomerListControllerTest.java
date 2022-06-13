package mj.oop.controller;

import mj.oop.application.CustomerShowService;
import mj.oop.application.interfaces.UserShowService;
import mj.oop.controller.interfaces.UserListController;
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

import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(CustomerListController.class)
@DisplayName("CustomerListController")
class CustomerListControllerTest {
    @MockBean
    private CustomerShowService service;
    @Autowired
    private MockMvc mockMvc;

    private final Long USER_ID = 1L;
    private final String USER_NAME = "Test User";
    private final String USER_EMAIL = "hello@gmail.com";
    private final String USER_PASSWORD = "yahOo~!@12345";
    private Customer user;

    @Nested
    @DisplayName("list 메소드는")
    class Describe_list {
        @BeforeEach
        void setUp() {
            user = Customer.builder()
                    .id(USER_ID)
                    .name(USER_NAME)
                    .email(USER_EMAIL)
                    .password(USER_PASSWORD)
                    .build();
            given(service.showAll()).willReturn(List.of(user));
        }

        @Test
        @DisplayName("HTTP Status Code 200 OK 응답한다")
        void it_responds_with_200_ok() throws Exception {
            mockMvc.perform(get("/users"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString(USER_NAME)));
        }
    }
}
