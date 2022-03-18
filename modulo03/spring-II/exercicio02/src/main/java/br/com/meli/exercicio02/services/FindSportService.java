package br.com.meli.exercicio02.services;

import br.com.meli.exercicio02.entities.Sport;
import br.com.meli.exercicio02.repositories.SportsRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class FindSportService {
    private SportsRepository sportsRepository;

    public Sport exec(String name) {
        Optional<Sport> sportFound = sportsRepository.getSports().stream().filter(sport -> sport.getName().equalsIgnoreCase(name)).findAny();

        if (sportFound.isPresent()) {
            return sportFound.get();
        }

        return null;
    }
}
