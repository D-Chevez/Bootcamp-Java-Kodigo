package service;

import model.User;

import java.util.List;
import java.util.Optional;

/**
 * Business operations over users.
 */
public interface UserService {
    User create(String name);
    Optional<User> get(String id);
    List<User> list();
}
