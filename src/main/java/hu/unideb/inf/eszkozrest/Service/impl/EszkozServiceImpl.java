package hu.unideb.inf.eszkozrest.Service.impl;

import hu.unideb.inf.eszkozrest.Dto.EszkozDto;
import hu.unideb.inf.eszkozrest.Entity.EszkozEntity;
import hu.unideb.inf.eszkozrest.Repository.EszkozRepository;
import hu.unideb.inf.eszkozrest.Service.EszkozService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EszkozServiceImpl implements EszkozService {

    @Autowired
    EszkozRepository eszkozRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<EszkozDto> saveAll(List<EszkozDto> list) {
        for (EszkozDto eszkozDto : list) {
            eszkozRepository.save(modelMapper.map(eszkozDto, EszkozEntity.class));
        }
        return null;
    }

    @Override
    public List<EszkozDto> listAll() {
        List<EszkozDto> eszkozok = new ArrayList<>();
        for (EszkozEntity ee : eszkozRepository.findAll()) {
            eszkozok.add(modelMapper.map(ee, EszkozDto.class));
        }
        return eszkozok;
    }

    @Override
    public EszkozDto save(EszkozDto eszkoz) {
        EszkozEntity eszkozEntity = modelMapper.map(eszkoz, EszkozEntity.class);
        eszkozEntity = eszkozRepository.save(eszkozEntity);
        return modelMapper.map(eszkozEntity, EszkozDto.class);
    }

    @Override
    public void deleteById(long id) {
        eszkozRepository.deleteById(id);
    }

    @Override
    public EszkozDto findById(long id) {
        EszkozEntity eszkozEntity = eszkozRepository.getReferenceById(id);
        /*EszkozDto eszkozDto = new EszkozDto();
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
        }*/

        EszkozDto eszkozDto1 = modelMapper.map(eszkozEntity, EszkozDto.class);

        return eszkozDto1;
    }
}
