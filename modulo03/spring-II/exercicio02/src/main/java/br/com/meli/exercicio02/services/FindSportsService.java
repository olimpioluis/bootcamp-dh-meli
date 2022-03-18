package br.com.meli.exercicio02.services;

import br.com.meli.exercicio02.entities.Sport;
import br.com.meli.exercicio02.repositories.SportsRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FindSportsService {
    private SportsRepository sportsRepository;

    public List<Sport> exec() {
        return sportsRepository.getInstance().getSports();
    }
}
