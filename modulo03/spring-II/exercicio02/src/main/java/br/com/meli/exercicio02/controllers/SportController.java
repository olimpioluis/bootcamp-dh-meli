package br.com.meli.exercicio02.controllers;

import br.com.meli.exercicio02.dtos.AthleteDTO;
import br.com.meli.exercicio02.entities.Sport;
import br.com.meli.exercicio02.repositories.PersonsRepository;
import br.com.meli.exercicio02.repositories.SportsRepository;
import br.com.meli.exercicio02.services.FindSportService;
import br.com.meli.exercicio02.services.FindSportsPersonsService;
import br.com.meli.exercicio02.services.FindSportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    @GetMapping("/findSports")
    public List<Sport> listSports() {
        return new FindSportsService(SportsRepository.getInstance()).exec();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> findByName(@PathVariable String name) {
        return new ResponseEntity<>(new FindSportService(SportsRepository.getInstance()).exec(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public List<AthleteDTO> listPersonsAndSports() {
        return new FindSportsPersonsService(SportsRepository.getInstance(), PersonsRepository.getInstance()).exec();
    }
}
