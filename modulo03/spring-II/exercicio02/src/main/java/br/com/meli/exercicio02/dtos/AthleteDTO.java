package br.com.meli.exercicio02.dtos;

import br.com.meli.exercicio02.entities.Person;
import br.com.meli.exercicio02.entities.Sport;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AthleteDTO {
    private String name;
    private String surname;
    private String sportName;

    public AthleteDTO convert(Person person, Sport sport) {
        this.name = person.getName();
        this.surname = person.getSurname();
        this.sportName = sport.getName();

        return this;
    }

    public static List<AthleteDTO> convert(List<Person> persons, List<Sport> sports) {
        List<AthleteDTO> athletes = new ArrayList<>();
        for(int i = 0; i < persons.size(); i++) {
            athletes.add(new AthleteDTO(persons.get(i).getName(), persons.get(i).getSurname(), sports.get(i).getName()));
        }

        return athletes;
    }
}
