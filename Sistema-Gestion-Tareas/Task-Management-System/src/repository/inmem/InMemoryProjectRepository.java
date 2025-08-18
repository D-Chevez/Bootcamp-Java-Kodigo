package repository.inmem;

import model.Project;
import repository.ProjectRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryProjectRepository implements ProjectRepository{
    private final Map<UUID, Project> store = new ConcurrentHashMap<>();

    @Override
    public Optional<Project> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Project> findAll() {
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
    public Project save(Project entity) {
        store.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Project> saveAll(List<Project> entities) {
        entities.forEach(this::save);
        return entities;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public void delete(Project entity) {
        store.clear();
    }
}
