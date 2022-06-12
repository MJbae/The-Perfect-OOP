package mj.oop.controller;


import mj.oop.application.KoreanBeefDeleteService;
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

import static org.mockito.BDDMockito.willThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WebMvcTest(KoreanBeefDeleteController.class)
@DisplayName("KoreanBeefDeleteController")
class KoreanBeefDeleteControllerTest {
    @MockBean
    private KoreanBeefDeleteService service;
    @Autowired
    private MockMvc mockMvc;

    private final Long PRODUCT_ID = 1L;
    private final Long PRODUCT_ID_NOT_EXISTING = 100L;

    @Nested
    @DisplayName("delete 메소드는")
    class Describe_delete {
        @Nested
        @DisplayName("유효한 매개변수를 전달 받는다면")
        class Context_with_valid_param {
            @Test
            @DisplayName("HTTP Status Code 204 NO CONTENT 응답한다")
            void it_responds_with_204() throws Exception {
                mockMvc.perform(delete("/beef/" + PRODUCT_ID))
                        .andExpect(status().isNoContent());
            }
        }

        @Nested
        @DisplayName("만약 존재하지 않는 ID를 매개변수로 전달 받는다면")
        class Context_without_existing_product {
            @BeforeEach
            void setUp() {
                willThrow(new NoSuchElementException(PRODUCT_ID_NOT_EXISTING.toString()))
                        .given(service).deleteBy(PRODUCT_ID_NOT_EXISTING);
            }

            @Test
            @DisplayName("HTTP Status Code 404 NOT FOUND 응답한다")
            void it_responds_with_404() throws Exception {
                mockMvc.perform(delete("/beef/" + PRODUCT_ID_NOT_EXISTING))
                        .andExpect(status().isNotFound());
            }

        }
    }


}
