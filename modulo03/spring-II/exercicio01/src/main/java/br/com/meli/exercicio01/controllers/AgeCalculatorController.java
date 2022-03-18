package br.com.meli.exercicio01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeCalculatorController {

    @GetMapping("/age/{day}/{month}/{year}")
    public Integer calculateAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears();
    }
}
