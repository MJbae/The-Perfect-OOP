package mj.oop.controller;

import mj.oop.application.KoreanBeefDeleteService;
import mj.oop.application.interfaces.ProductDeleteService;
import mj.oop.controller.interfaces.ProductDeleteController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class KoreanBeefDeleteController implements ProductDeleteController {
    private final ProductDeleteService service;

    public KoreanBeefDeleteController(KoreanBeefDeleteService service) {
        this.service = service;
    }

    @DeleteMapping("/beef/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void delete(@PathVariable Long id) {
        service.deleteBy(id);
    }

}
