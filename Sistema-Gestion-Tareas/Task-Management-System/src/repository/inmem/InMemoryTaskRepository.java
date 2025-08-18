package repository.inmem;

import model.Task;
import repository.TaskRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTaskRepository implements TaskRepository{
    private final Map<UUID, Task> store = new ConcurrentHashMap<>();

    @Override
    public Optional<Task> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public boolean existsById(UUID id) {
        return store.containsKey(id);
    }

    @Override
    public long count() {
        return store.size();
    }

    @Override
    public Task save(Task entity) {
        store.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Task> saveAll(List<Task> entities) {
        entities.forEach(this::save);
        return entities;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public void delete(Task entity) {
        store.clear();
    }
}
