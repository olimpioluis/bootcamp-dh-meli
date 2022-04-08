package br.com.meli.exercicio01.service;

import br.com.meli.exercicio01.dto.PearlDTO;
import br.com.meli.exercicio01.entity.Pearl;
import br.com.meli.exercicio01.exception.PearlNotFoundException;
import br.com.meli.exercicio01.repository.PearlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class PearlService implements IPearlService {

    @Autowired
    private PearlRepository pearlRepository;

    @Override
    public PearlDTO savePearl(PearlDTO pearlDTO) {
        return PearlDTO.pearlToDTO(pearlRepository.save(PearlDTO.dtoToPearl(pearlDTO)));
    }

    @Override
    public List<PearlDTO> getPearls() {
        return PearlDTO.pearlsToDTOs(pearlRepository.findAll());
    }

    @Transactional
    @Override
    public void deletePearl(Integer codeId) {
        pearlRepository.findByCodeId(codeId).orElseThrow(() -> new PearlNotFoundException(codeId));

        pearlRepository.deleteByCodeId(codeId);
    }

    @Override
    public PearlDTO updatePearl(PearlDTO pearlDTO, Integer codeId) {
        Pearl pearl = pearlRepository.findByCodeId(codeId).orElseThrow(() -> new PearlNotFoundException(codeId));

        return PearlDTO.pearlToDTO(pearlRepository.save(
                Pearl.builder()
                        .id(pearl.getId())
                        .codeId(pearl.getCodeId())
                        .carats(Objects.isNull(pearlDTO.getCarats()) ? pearl.getCarats() : pearlDTO.getCarats())
                        .material(Objects.isNull(pearlDTO.getMaterial()) ? pearl.getMaterial() : pearlDTO.getMaterial())
                        .weightKg(Objects.isNull(pearlDTO.getWeightKg()) ? pearl.getWeightKg() : pearlDTO.getWeightKg())
                        .build()
        ));
    }
}
