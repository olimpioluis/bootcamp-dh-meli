package br.com.meli.exercicio02.repositories;

import br.com.meli.exercicio02.entities.Sport;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class SportsRepository {
    private List<Sport> sports = new ArrayList<>(Arrays.asList(
            new Sport("Futebol", "Profissional"),
            new Sport("Basquete", "Amador"),
            new Sport(),
            new Sport("Golf", "Profissional")
    ));

    private static final SportsRepository INSTANCE = new SportsRepository();

    private SportsRepository() {};

    public static SportsRepository getInstance() {
        return INSTANCE;
    }
}
