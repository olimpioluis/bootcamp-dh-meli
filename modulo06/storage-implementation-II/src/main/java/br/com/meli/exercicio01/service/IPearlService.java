package br.com.meli.exercicio01.service;

import br.com.meli.exercicio01.dto.PearlDTO;

import java.util.List;

public interface IPearlService {
    PearlDTO savePearl(PearlDTO pearlDTO);
    List<PearlDTO> getPearls();
    void deletePearl(Integer codeId);
    PearlDTO updatePearl(PearlDTO pearlDTO, Integer codeId);
}
