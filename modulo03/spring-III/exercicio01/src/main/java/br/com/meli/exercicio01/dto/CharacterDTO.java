package br.com.meli.exercicio01.dto;

import br.com.meli.exercicio01.entity.Character;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CharacterDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterDTO convert(Character character) {
        this.name = character.getName();
        this.height = character.getHeight();
        this.mass = character.getMass();
        this.gender = character.getGender();
        this.homeworld = character.getHomeworld();
        this.species = character.getSpecies();
        return this;
    }

    public static List<CharacterDTO> convert(List<Character> characters) {
        return characters.stream().map(character -> new CharacterDTO(character.getName(), character.getHeight(), character.getMass(), character.getGender(), character.getHomeworld(), character.getSpecies())).collect(Collectors.toList());
    }
}
