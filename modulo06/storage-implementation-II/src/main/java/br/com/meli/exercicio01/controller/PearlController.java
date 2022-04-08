package br.com.meli.exercicio01.controller;

import br.com.meli.exercicio01.dto.PearlDTO;
import br.com.meli.exercicio01.service.PearlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PearlController {

    @Autowired
    private PearlService pearlService;

    @PostMapping("/pearl")
    public ResponseEntity<PearlDTO> postPearl(@RequestBody PearlDTO pearlDTO) {
        return new ResponseEntity<>(pearlService.savePearl(pearlDTO), HttpStatus.CREATED);
    }

    @GetMapping("/pearls")
    public ResponseEntity<List<PearlDTO>> getPearls() {
        return new ResponseEntity<>(pearlService.getPearls(), HttpStatus.OK);
    }

    @DeleteMapping("/pearl")
    public ResponseEntity<String> deletePearl(@RequestParam(name = "codeId") Integer codeId) {
        pearlService.deletePearl(codeId);

        return new ResponseEntity<>("Resource deleted succesfully", HttpStatus.OK);
    }

    @PutMapping("/pearl")
    public ResponseEntity<PearlDTO> putPearl(@RequestParam(name = "codeId") Integer codeId, @RequestBody PearlDTO pearlDTO) {
        return new ResponseEntity<>(pearlService.updatePearl(pearlDTO, codeId), HttpStatus.OK);
    }
}
