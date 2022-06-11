package mj.oop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mj.oop.application.KoreanBeefCreateService;
import mj.oop.controller.dto.KoreanBeefRequestData;
import mj.oop.domain.entity.KoreanBeef;
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

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(KoreanBeefCreateController.class)
@DisplayName("KoreanBeefCreateController")
class KoreanBeefCreateControllerTest {
    @MockBean
    private KoreanBeefCreateService service;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private final String PRODUCT_NAME = "세상에서 제일 맛있는 한우";
    private final BigDecimal PRICE = new BigDecimal(1000);
    private final String MEAT_GRADE = "1+";
    private final Long PRODUCT_ID = 1L;

    private KoreanBeef product;

    @Nested
    @DisplayName("create 메소드는")
    class Describe_create {
        @BeforeEach
        void setUp() {
            product = KoreanBeef.builder()
                    .id(PRODUCT_ID)
                    .name(PRODUCT_NAME)
                    .price(PRICE)
                    .meatGrade(MEAT_GRADE)
                    .build();

            given(service.create(any(KoreanBeef.class))).willReturn(product);
        }

        @Nested
        @DisplayName("유효한 매개변수를 전달 받는다면")
        class Context_with_all_valid_params {
            @Test
            @DisplayName("HTTP Status Code 201 CREATED 응답한다")
            void it_responds_with_201() throws Exception {
                mockMvc.perform(post("/beef")
                                .content(jsonFrom(product))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated());
            }
        }

        @Nested
        @DisplayName("빈값의 이름을 받는다면")
        class Context_with_empty_param {
            @BeforeEach
            void setUp() {
                product = KoreanBeef.builder()
                        .id(PRODUCT_ID)
                        .name("")
                        .price(PRICE)
                        .meatGrade(MEAT_GRADE)
                        .build();

                given(service.create(any(KoreanBeef.class))).willReturn(product);
            }
            @Test
            @DisplayName("HTTP Status Code 400 BAD REQUEST 응답한다")
            void it_responds_with_400() throws Exception {
                mockMvc.perform(post("/beef")
                                .content(jsonFrom(product))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
            }
        }

        @Nested
        @DisplayName("공백의 이름을 받는다면")
        class Context_with_space_param {
            @BeforeEach
            void setUp() {
                product = KoreanBeef.builder()
                        .id(PRODUCT_ID)
                        .name(" ")
                        .price(PRICE)
                        .meatGrade(MEAT_GRADE)
                        .build();

                given(service.create(any(KoreanBeef.class))).willReturn(product);
            }
            @Test
            @DisplayName("HTTP Status Code 400 BAD REQUEST 응답한다")
            void it_responds_with_400() throws Exception {
                mockMvc.perform(post("/beef")
                                .content(jsonFrom(product))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
            }
        }

        @Nested
        @DisplayName("가격을 NULL로 받는다면")
        class Context_with_null_price {
            @BeforeEach
            void setUp() {
                product = KoreanBeef.builder()
                        .id(PRODUCT_ID)
                        .name(PRODUCT_NAME)
                        .meatGrade(MEAT_GRADE)
                        .build();

                given(service.create(any(KoreanBeef.class))).willReturn(product);
            }
            @Test
            @DisplayName("HTTP Status Code 400 BAD REQUEST 응답한다")
            void it_responds_with_400() throws Exception {
                mockMvc.perform(post("/beef")
                                .content(jsonFrom(product))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
            }
        }
    }

    private String jsonFrom(KoreanBeef product) throws JsonProcessingException {
        KoreanBeefRequestData requestData = KoreanBeefRequestData.builder()
                .name(product.getName())
                .price(product.getPrice())
                .meatGrade(product.getMeatGrade())
                .build();

        return objectMapper.writeValueAsString(requestData);
    }
}
