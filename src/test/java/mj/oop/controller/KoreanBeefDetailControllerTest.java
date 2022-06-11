package mj.oop.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import mj.oop.application.KoreanBeefShowService;
import mj.oop.domain.entity.KoreanBeef;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WebMvcTest(KoreanBeefDetailController.class)
@DisplayName("KoreanBeefDetailController")
class KoreanBeefDetailControllerTest {
    @MockBean
    private KoreanBeefShowService service;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private final String PRODUCT_NAME = "세상에서 제일 맛있는 한우";
    private final BigDecimal PRICE = new BigDecimal(1000);
    private final String MEAT_GRADE = "1+";
    private final Long PRODUCT_ID = 1L;
    private final Long PRODUCT_ID_NOT_EXISTING = 100L;

    private KoreanBeef product;

    @Nested
    @DisplayName("detail 메소드는")
    class Describe_detail {
        @Nested
        @DisplayName("유효한 매개변수를 전달 받는다면")
        class Context_with_valid_param {
            @BeforeEach
            void setUp() {
                product = KoreanBeef.builder()
                        .id(PRODUCT_ID)
                        .name(PRODUCT_NAME)
                        .price(PRICE)
                        .meatGrade(MEAT_GRADE)
                        .build();

                given(service.showBy(PRODUCT_ID)).willReturn(product);
            }

            @Test
            @DisplayName("HTTP Status Code 200 OK 응답한다")
            void it_responds_with_200_ok() throws Exception {
                mockMvc.perform(get("/beef/" + PRODUCT_ID))
                        .andExpect(status().isOk());
            }
        }

        @Nested
        @DisplayName("만약 존재하지 않는 ID를 매개변수로 전달 받는다면")
        class Context_with_invalid_param {
            @BeforeEach
            void setUp() {
                product = KoreanBeef.builder()
                        .id(PRODUCT_ID_NOT_EXISTING)
                        .name(PRODUCT_NAME)
                        .price(PRICE)
                        .meatGrade(MEAT_GRADE)
                        .build();

                given(service.showBy(PRODUCT_ID_NOT_EXISTING))
                        .willThrow(new NoSuchElementException(PRODUCT_ID_NOT_EXISTING.toString()));
            }

            @Test
            @DisplayName("HTTP Status Code 404 NOT FOUND 응답한다")
            void it_responds_with_404() throws Exception {
                mockMvc.perform(get("/beef/" + PRODUCT_ID_NOT_EXISTING))
                        .andExpect(status().isNotFound());
            }
        }
    }
}
