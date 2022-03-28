package br.com.meli.exercicio01.dto;

import br.com.meli.exercicio01.entity.Character;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CharacterFilteredDTO {
    private String name;
    private Double height;
    private Double mass;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public static List<CharacterFilteredDTO> convert(List<Character> characters) {
        return characters.stream().map(character ->
                new CharacterFilteredDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getBirthYear(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()))
                .collect(Collectors.toList());
    }
}
