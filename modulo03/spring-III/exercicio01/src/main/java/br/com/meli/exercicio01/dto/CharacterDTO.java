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
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public Character convert() {
        return new Character(
                this.name,
                this.height.equalsIgnoreCase("NA") ? 0 : Double.parseDouble(this.height),
                this.mass.equalsIgnoreCase("NA") ? 0 : Double.parseDouble(this.mass),
                this.hairColor,
                this.skinColor,
                this.eyeColor,
                this.birthYear,
                this.gender,
                this.homeworld,
                this.species
        );
    }
}
