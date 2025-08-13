package service;

import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserServiceImp implements UserService{
    private final UserRepository users;

    public UserServiceImp(UserRepository users) {
        this.users = users;
    }

    @Override
    public User create(String name) {
        User u = new User(UUID.randomUUID().toString(), name);
        users.save(u);
        return u;
    }

    @Override public Optional<User> get(String id) { return users.findById(id); }
    @Override public List<User> list() { return users.findAll(); }
}
