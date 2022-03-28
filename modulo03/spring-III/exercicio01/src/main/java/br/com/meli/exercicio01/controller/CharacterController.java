package br.com.meli.exercicio01.controller;

import br.com.meli.exercicio01.dto.CharacterDTO;
import br.com.meli.exercicio01.dto.CharacterFilteredDTO;
import br.com.meli.exercicio01.entity.Character;
import br.com.meli.exercicio01.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/character")
    public ResponseEntity<List<CharacterFilteredDTO>> getCharacterByName(@RequestParam String name) {
        return ResponseEntity.ok().body(characterService.findByName(name));
    }

    @PostMapping("/character")
    public ResponseEntity<List<CharacterDTO>> saveCharacters(@RequestBody List<CharacterDTO> characters) {
        List<Character> newCharacters = characters.stream().map(characterDTO -> characterDTO.convert()).collect(Collectors.toList());

        return new ResponseEntity(characterService.saveAll(newCharacters), HttpStatus.CREATED);
    }
}
