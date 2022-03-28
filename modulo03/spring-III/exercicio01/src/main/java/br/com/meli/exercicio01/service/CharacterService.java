package br.com.meli.exercicio01.service;

import br.com.meli.exercicio01.dto.CharacterFilteredDTO;
import br.com.meli.exercicio01.entity.Character;
import br.com.meli.exercicio01.exception.CharacterAlreadyExistsException;
import br.com.meli.exercicio01.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterFilteredDTO> findByName(String name) {
        return CharacterFilteredDTO.convert(characterRepository.getCharactersByName(name));
    }

    public List<CharacterFilteredDTO> saveAll(List<Character> characters) {
        Optional<Character> characterFound;

        for (Character character: characters) {
            characterFound = characterRepository.findOne(character.getName());

            if (characterFound.isPresent()) {
                throw new CharacterAlreadyExistsException("o personagem " + characterFound.get().getName() + " já foi cadastrado! Os personagens seguintes a ele na lista não serão cadastrados.");            }
        }

        return CharacterFilteredDTO.convert(characterRepository.saveAll(characters));
    }
}
