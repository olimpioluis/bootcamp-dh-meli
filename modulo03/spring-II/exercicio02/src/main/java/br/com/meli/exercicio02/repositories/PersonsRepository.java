package br.com.meli.exercicio02.repositories;

import br.com.meli.exercicio02.entities.Person;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class PersonsRepository {
    private List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person("Luis", "Olimpio", 22),
            new Person("Felipe", "Floriano", 22),
            new Person("Luis", "Floriano", 22),
            new Person("Felipe", "Olimpio", 22)
    ));

    private static final PersonsRepository INSTANCE = new PersonsRepository();

    private PersonsRepository() {};

    public static PersonsRepository getInstance() {
        return INSTANCE;
    }
}
