package mj.oop.controller;

import mj.oop.application.KoreanBeefShowService;
import mj.oop.application.interfaces.ProductShowService;
import mj.oop.controller.dto.KoreanBeefResponseData;
import mj.oop.controller.interfaces.ProductListController;
import mj.oop.domain.entity.KoreanBeef;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class KoreanBeefListController implements ProductListController<KoreanBeefResponseData> {
    private final ProductShowService<KoreanBeef> service;

    public KoreanBeefListController(KoreanBeefShowService service) {
        this.service = service;
    }

    @GetMapping("/beef")
    @Override
    public List<KoreanBeefResponseData> list() {
        return service.showAll().stream()
                .map(KoreanBeefResponseData::from)
                .collect(Collectors.toList());
    }
}
