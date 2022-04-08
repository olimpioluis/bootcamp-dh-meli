package br.com.meli.exercicio01.exception.handler;

import br.com.meli.exercicio01.dto.ErrorDTO;
import br.com.meli.exercicio01.exception.PearlNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralHandler {

    @ExceptionHandler(PearlNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlePearlNotFoundException(PearlNotFoundException ex) {
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }
}
