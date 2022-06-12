package mj.oop.controller;

import mj.oop.application.KoreanBeefUpdateService;
import mj.oop.application.interfaces.ProductUpdateService;
import mj.oop.controller.dto.KoreanBeefRequestData;
import mj.oop.controller.dto.KoreanBeefResponseData;
import mj.oop.controller.interfaces.ProductUpdateController;
import mj.oop.domain.entity.KoreanBeef;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class KoreanBeefUpdateController implements ProductUpdateController<KoreanBeefResponseData, KoreanBeefRequestData> {
    private final ProductUpdateService<KoreanBeef> service;

    public KoreanBeefUpdateController(KoreanBeefUpdateService service) {
        this.service = service;
    }

    @PatchMapping("/beef/{id}")
    @Override
    public KoreanBeefResponseData update(@PathVariable Long id, @RequestBody @Valid KoreanBeefRequestData requestData) {
        KoreanBeef product = service.update(id, requestData.toEntity());
        return KoreanBeefResponseData.from(product);
    }
}
