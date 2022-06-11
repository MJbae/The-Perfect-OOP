package mj.oop.controller;

import mj.oop.application.KoreanBeefShowService;
import mj.oop.application.interfaces.ProductShowService;
import mj.oop.controller.dto.KoreanBeefResponseData;
import mj.oop.controller.interfaces.ProductDetailController;
import mj.oop.domain.entity.KoreanBeef;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class KoreanBeefDetailController implements ProductDetailController<KoreanBeefResponseData> {
    @GetMapping("/beef/{id}")
    @Override
    public KoreanBeefResponseData detail(@PathVariable Long id) {
        return new KoreanBeefResponseData(1L, "맛있는 한우", new BigDecimal(1000), "1+");
    }
}
