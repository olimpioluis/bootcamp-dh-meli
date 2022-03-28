package br.com.meli.exercicio01.exception;

public class CharacterAlreadyExistsException extends RuntimeException {
    public CharacterAlreadyExistsException(String message) {
        super(message);
    }
}
