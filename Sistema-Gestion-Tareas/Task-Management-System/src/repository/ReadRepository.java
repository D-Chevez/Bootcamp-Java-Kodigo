package repository;

import java.util.List;
import java.util.Optional;

public interface ReadRepository<T, ID> {
    Optional<T> findById(ID id);
    List<T> findAll();
    boolean existsById(ID id);
    long count();
}