package hu.unideb.inf.eszkozrest.Controller;

import hu.unideb.inf.eszkozrest.Dto.EszkozDto;
import hu.unideb.inf.eszkozrest.Entity.EszkozEntity;
import hu.unideb.inf.eszkozrest.Repository.EszkozRepository;
import hu.unideb.inf.eszkozrest.Service.EszkozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EszkozController {

    @Autowired
    EszkozRepository eszkozRepository;

    @Autowired
    EszkozService eszkozService;

    @GetMapping("/eszkoz")
    public ResponseEntity<EszkozDto> getEszkoz(@RequestParam long id) {
        return new ResponseEntity<>(
                eszkozService.findById(id)
                //eszkozRepository.findById(id).get()
                , HttpStatus.OK);
    }

    @PostMapping("/eszkozInit")
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
            //return new ResponseEntity<>(eszkozRepository.findAll(),HttpStatus.OK);
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

    @PostMapping("/eszkoz")
    public ResponseEntity<EszkozEntity> saveEszkoz(@RequestBody EszkozEntity eszkoz) {
        return new ResponseEntity<>(eszkozRepository.save(eszkoz), HttpStatus.CREATED);
    }

    @DeleteMapping("/eszkoz")
    public ResponseEntity deleteEszkoz(@RequestParam(required = true) long id) {
        eszkozRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/eszkoz")
    public ResponseEntity<EszkozEntity> updateEszkoz(@RequestBody EszkozEntity eszkoz, @RequestParam long id) {
        EszkozEntity eszkozEntity = eszkozRepository.getReferenceById(id);
        eszkozEntity.setMarka(eszkoz.getMarka());
        eszkozEntity.setTipus(eszkoz.getTipus());
        eszkozEntity.setLeiras(eszkoz.getLeiras());
        eszkozEntity.setJelleg(eszkoz.getJelleg());

        return new ResponseEntity<>(eszkozRepository.save(eszkozEntity), HttpStatus.CREATED);
    }


}
