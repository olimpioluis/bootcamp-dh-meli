package br.com.meli.exercicio02.services;

import br.com.meli.exercicio02.dtos.AthleteDTO;
import br.com.meli.exercicio02.repositories.PersonsRepository;
import br.com.meli.exercicio02.repositories.SportsRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@AllArgsConstructor
public class FindSportsPersonsService {
    private SportsRepository sportsRepository;
    private PersonsRepository personsRepository;

    public List<AthleteDTO> exec() {
        List<AthleteDTO> athletes = AthleteDTO.convert(personsRepository.getInstance().getPersons(), sportsRepository.getInstance().getSports()).stream().filter(athlete -> athlete.getSportName() != null).collect(Collectors.toList());

        return athletes;
    }
}
