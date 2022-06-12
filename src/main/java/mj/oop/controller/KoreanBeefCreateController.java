package mj.oop.controller;

import mj.oop.application.KoreanBeefCreateService;
import mj.oop.application.interfaces.ProductCreateService;
import mj.oop.application.interfaces.ProductShowService;
import mj.oop.controller.dto.KoreanBeefRequestData;
import mj.oop.controller.dto.KoreanBeefResponseData;
import mj.oop.controller.interfaces.ProductCreateController;
import mj.oop.domain.entity.KoreanBeef;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
public class KoreanBeefCreateController implements ProductCreateController<KoreanBeefResponseData, KoreanBeefRequestData> {
    private final ProductCreateService<KoreanBeef> service;

    public KoreanBeefCreateController(KoreanBeefCreateService service) {
        this.service = service;
    }

    @PostMapping("/beef")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public KoreanBeefResponseData create(@RequestBody @Valid KoreanBeefRequestData requestDto) {
        KoreanBeef product = service.create(requestDto.toEntity());
        return KoreanBeefResponseData.from(product);
    }
}
