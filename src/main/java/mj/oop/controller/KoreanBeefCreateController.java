package mj.oop.controller;

import mj.oop.controller.dto.KoreanBeefRequestData;
import mj.oop.controller.dto.KoreanBeefResponseData;
import mj.oop.controller.interfaces.ProductCreateController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
public class KoreanBeefCreateController implements ProductCreateController<KoreanBeefResponseData, KoreanBeefRequestData> {
    @PostMapping("/beef")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public KoreanBeefResponseData create(@RequestBody @Valid KoreanBeefRequestData requestDto) {
        return new KoreanBeefResponseData(1L, "맛있는 한우", new BigDecimal(1000), "1+");
    }
}
