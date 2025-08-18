package repository.inmem;

import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserRepository implements UserRepository{
    private final Map<UUID, User> store = new ConcurrentHashMap<>();

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
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
    public User save(User entity) {
        store.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<User> saveAll(List<User> entities) {
        entities.forEach(this::save);
        return entities;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public void delete(User entity) {
        store.clear();
    }
}
