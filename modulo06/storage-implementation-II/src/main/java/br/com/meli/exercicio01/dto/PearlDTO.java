package br.com.meli.exercicio01.dto;

import br.com.meli.exercicio01.entity.Pearl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PearlDTO {
    private Integer codeId;
    private String material;
    private BigDecimal weightKg;
    private Integer carats;

    public static Pearl dtoToPearl(PearlDTO pearlDTO) {
        return Pearl.builder().codeId(pearlDTO.getCodeId()).material(pearlDTO.getMaterial()).weightKg(pearlDTO.weightKg).carats(pearlDTO.getCarats()).build();
    }

    public static PearlDTO pearlToDTO(Pearl pearl) {
        return new PearlDTO(pearl.getCodeId(), pearl.getMaterial(), pearl.getWeightKg(), pearl.getCarats());
    }

    public static List<PearlDTO> pearlsToDTOs(List<Pearl> pearls) {
        return pearls.stream().map(pearl -> new PearlDTO(pearl.getCodeId(), pearl.getMaterial(), pearl.getWeightKg(), pearl.getCarats())).collect(Collectors.toList());
    }

}
