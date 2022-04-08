package br.com.meli.exercicio01.exception;

import br.com.meli.exercicio01.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PearlNotFoundException extends RuntimeException {

    private ErrorDTO error;
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public PearlNotFoundException(Integer codeId) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), "The code id " + codeId + " is not registered");
    }
}
