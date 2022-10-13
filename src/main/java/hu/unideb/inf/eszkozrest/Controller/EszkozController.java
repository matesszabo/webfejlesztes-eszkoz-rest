package hu.unideb.inf.eszkozrest.Controller;

import hu.unideb.inf.eszkozrest.Entity.EszkozEntity;
import hu.unideb.inf.eszkozrest.Repository.EszkozRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EszkozController {

    @Autowired
    EszkozRepository eszkozRepository;

    @GetMapping("/eszkoz")
    public ResponseEntity<EszkozEntity> getEszkoz() {
        return new ResponseEntity<>(
                new EszkozEntity(1, "Samsung", "Tab S6",
                        "piros tablet", "tablet")
                , HttpStatus.OK);
    }

    @PostMapping("/eszkoz")
    public ResponseEntity<List<EszkozEntity>> saveEszkozok() {
        List<EszkozEntity> eszkozok = Arrays.asList(
                new EszkozEntity("Huawei", "Nova 5", "fehér telefon", "telefon"),
                new EszkozEntity("Huawei", "MatePad 11", "betört kijelző", "tablet"),
                new EszkozEntity("Apple", "iPhone XS", "akkumulátor probléma", "telefon")
        );
        return new ResponseEntity<>(eszkozRepository.saveAll(eszkozok), HttpStatus.CREATED);
    }

    @GetMapping("/eszkozok")
    public ResponseEntity<List<EszkozEntity>> getEszkozok() {
        try {
            List<EszkozEntity> eszkozok = eszkozRepository.findAll();
            if (eszkozok.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(eszkozok, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
