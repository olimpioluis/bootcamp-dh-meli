package br.com.meli.exercicio01.repository;

import br.com.meli.exercicio01.entity.Pearl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PearlRepository extends JpaRepository<Pearl, Integer> {
    Optional<Pearl> findByCodeId(Integer codeId);

    void deleteByCodeId(Integer codeId);
}
