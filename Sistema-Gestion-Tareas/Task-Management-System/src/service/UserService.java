package service;

import model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User create(User user);
    List<User> findAll();
    void delete(UUID id);
    Optional<User> findById(UUID id);
}