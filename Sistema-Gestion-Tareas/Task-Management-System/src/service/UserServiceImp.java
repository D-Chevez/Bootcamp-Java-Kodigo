package service;

import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserServiceImp implements UserService {
    private final UserRepository repo;

    public UserServiceImp(UserRepository repo) { this.repo = Objects.requireNonNull(repo); }

    @Override
    public User create(User user)
    {
        return repo.save(user);
    }

    @Override
    public List<User> findAll()
    {
        return repo.findAll();
    }

    @Override
    public void delete(UUID id)
    {
        repo.deleteById(id);
    }

    @Override
    public Optional<User> findById(UUID id)
    {
        return repo.findById(id);
    }
}
