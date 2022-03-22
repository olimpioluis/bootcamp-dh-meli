package br.com.meli.exercicio01.service;

import br.com.meli.exercicio01.dto.CharacterDTO;
import br.com.meli.exercicio01.entity.Character;
import br.com.meli.exercicio01.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterDTO> findByName(String name) {
        return CharacterDTO.convert(characterRepository.getCharactersByName(name));
    }

    public List<CharacterDTO> saveAll(List<Character> characters) {
        return CharacterDTO.convert(characterRepository.saveAll(characters));
    }
}
