package mj.oop.controller;

import mj.oop.application.KoreanBeefShowService;
import mj.oop.application.interfaces.ProductShowService;
import mj.oop.controller.dto.KoreanBeefResponseData;
import mj.oop.controller.interfaces.ProductDetailController;
import mj.oop.domain.entity.KoreanBeef;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KoreanBeefDetailController implements ProductDetailController<KoreanBeefResponseData> {
    private final ProductShowService<KoreanBeef> service;

    public KoreanBeefDetailController(KoreanBeefShowService service) {
        this.service = service;
    }

    @GetMapping("/beef/{id}")
    @Override
    public KoreanBeefResponseData detail(@PathVariable Long id) {
        KoreanBeef product = service.showBy(id);
        return KoreanBeefResponseData.from(product);
    }
}
