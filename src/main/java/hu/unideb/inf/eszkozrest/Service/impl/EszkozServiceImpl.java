package hu.unideb.inf.eszkozrest.Service.impl;

import hu.unideb.inf.eszkozrest.Dto.EszkozDto;
import hu.unideb.inf.eszkozrest.Dto.TulajdonosDto;
import hu.unideb.inf.eszkozrest.Entity.EszkozEntity;
import hu.unideb.inf.eszkozrest.Repository.EszkozRepository;
import hu.unideb.inf.eszkozrest.Service.EszkozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EszkozServiceImpl implements EszkozService {

    @Autowired
    EszkozRepository eszkozRepository;

    @Override
    public List<EszkozDto> saveAll(List<EszkozDto> list) {
        return null;
    }

    @Override
    public List<EszkozDto> listAll() {
        return null;
    }

    @Override
    public EszkozDto save(EszkozDto eszkoz) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public EszkozDto findById(long id) {
        EszkozEntity eszkozEntity = eszkozRepository.getReferenceById(id);
        EszkozDto eszkozDto = new EszkozDto();
        eszkozDto.setId(eszkozEntity.getId());
        eszkozDto.setJelleg(eszkozEntity.getJelleg());
        eszkozDto.setLeiras(eszkozEntity.getLeiras());
        eszkozDto.setMarka(eszkozEntity.getMarka());
        eszkozDto.setTipus(eszkozEntity.getTipus());
        if (eszkozEntity.getTulajdonos() != null) {
            eszkozDto.setTulajdonos(new TulajdonosDto(
                    eszkozEntity.getTulajdonos().getId(),
                    eszkozEntity.getTulajdonos().getNev(),
                    eszkozEntity.getTulajdonos().getSzemelyi(),
                    eszkozEntity.getTulajdonos().getSzuldatum()
            ));
        }

        return eszkozDto;
    }
}
