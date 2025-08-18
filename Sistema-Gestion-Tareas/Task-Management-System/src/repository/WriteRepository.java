package repository;

import java.util.List;

public interface WriteRepository<T, ID> {
    T save(T entity);
    List<T> saveAll(List<T> entities);
    void deleteById(ID id);
    void delete(T entity);
}