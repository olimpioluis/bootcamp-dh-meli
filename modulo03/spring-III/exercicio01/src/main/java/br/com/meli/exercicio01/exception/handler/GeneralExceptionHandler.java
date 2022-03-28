package br.com.meli.exercicio01.exception.handler;

import br.com.meli.exercicio01.exception.CharacterAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(value = CharacterAlreadyExistsException.class)
    protected ResponseEntity<Object> handleCharacterAlreadyExistsException(CharacterAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
    }
}
