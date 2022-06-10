package mj.oop.controller;

import mj.oop.controller.dto.KoreanBeefResponseData;
import mj.oop.controller.interfaces.ProductListController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class KoreanBeefListController implements ProductListController<KoreanBeefResponseData> {
    @GetMapping("/beef")
    @Override
    public List<KoreanBeefResponseData> list() {
        return List.of(new KoreanBeefResponseData(1L, "맛있는 한우", new BigDecimal(100), "1+"));
    }
}
