package mj.oop.controller;

import mj.oop.application.interfaces.ProductShowService;
import mj.oop.domain.entity.KoreanBeef;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(KoreanBeefListController.class)
@DisplayName("KoreanBeefListController")
class KoreanBeefListControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductShowService<KoreanBeef> service;

    private final String PRODUCT_NAME = "세상에서 제일 맛있는 한우";
    private final BigDecimal PRICE = new BigDecimal(1000);
    private final String MEAT_GRADE = "1+";
    private final Long PRODUCT_ID = 1L;

    private KoreanBeef product;

    @Nested
    @DisplayName("list 메소드는")
    class Describe_list {
        @BeforeEach
        void setUp() {
            product = KoreanBeef.builder()
                    .id(PRODUCT_ID)
                    .name(PRODUCT_NAME)
                    .price(PRICE)
                    .meatGrade(MEAT_GRADE)
                    .build();

            given(service.showAll()).willReturn(List.of(product));
        }

        @Test
        @DisplayName("HTTP Status Code 200 OK 응답한다")
        void it_responds_with_200_ok() throws Exception {
            mockMvc.perform(get("/beef"))
                    .andExpect(status().isOk());
        }
    }
}
