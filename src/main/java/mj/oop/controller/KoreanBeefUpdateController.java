package mj.oop.controller;

import mj.oop.controller.dto.KoreanBeefRequestData;
import mj.oop.controller.dto.KoreanBeefResponseData;
import mj.oop.controller.interfaces.ProductUpdateController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
public class KoreanBeefUpdateController implements ProductUpdateController<KoreanBeefResponseData, KoreanBeefRequestData> {

    @PatchMapping("/beef/{id}")
    @Override
    public KoreanBeefResponseData update(@PathVariable Long id, @RequestBody @Valid KoreanBeefRequestData requestData) {
        return new KoreanBeefResponseData(id, "맛있는 한우", new BigDecimal(1000), "1+");
    }
}
