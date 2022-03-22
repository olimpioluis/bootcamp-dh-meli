package br.com.meli.exercicio01.controller;

import br.com.meli.exercicio01.dto.CharacterDTO;
import br.com.meli.exercicio01.entity.Character;
import br.com.meli.exercicio01.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/character")
    public ResponseEntity<List<CharacterDTO>> getCharacterByName(@RequestParam String name) {
        return ResponseEntity.ok().body(characterService.findByName(name));
    }

    @PostMapping("/character")
    public ResponseEntity<List<CharacterDTO>> saveCharacters(@RequestBody List<Character> characters) {

        return ResponseEntity.ok().body(characterService.saveAll(characters));
    }
}
