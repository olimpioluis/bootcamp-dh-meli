package br.com.meli.exercicio01.repository;

import br.com.meli.exercicio01.entity.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository {
    private static List<Character> characters = new ArrayList<>();

    public List<Character> getCharactersByName(String name) {
        return characters.stream().filter(character -> character.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }

    public Optional<Character> findOne(String name) {
        return characters.stream().filter(character -> character.getName().equals(name)).findFirst();
    }

    public List<Character> saveAll(List<Character> characters) {
        if(CharacterRepository.characters.addAll(characters)) return characters;

        return new ArrayList<>();
    }
}
