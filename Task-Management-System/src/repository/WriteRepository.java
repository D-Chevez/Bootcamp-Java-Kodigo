package repository;

public interface WriteRepository<T> {
    void save(T entity);
    void deleteById(String id);
}