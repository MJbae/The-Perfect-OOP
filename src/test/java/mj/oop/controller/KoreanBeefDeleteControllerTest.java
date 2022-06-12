package mj.oop.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WebMvcTest(KoreanBeefDeleteController.class)
@DisplayName("KoreanBeefDeleteController")
class KoreanBeefDeleteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final Long PRODUCT_ID = 1L;

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
    }
}
