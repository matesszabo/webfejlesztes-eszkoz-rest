package hu.unideb.inf.eszkozrest.Controller;

import hu.unideb.inf.eszkozrest.Entity.EszkozEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EszkozController {

    @GetMapping("/eszkoz")
    public ResponseEntity<EszkozEntity> getEszkoz() {
        return new ResponseEntity<>(
                new EszkozEntity(1, "Samsung", "Tab S6",
                        "piros tablet", "tablet")
                , HttpStatus.OK);
    }


}
