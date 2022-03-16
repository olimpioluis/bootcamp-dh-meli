package repositories;

import entities.Client;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> list();
    void save(T obj);
    Optional<T> findById(Long id);
    void showAll();
    void deleteById(Long id);
}
