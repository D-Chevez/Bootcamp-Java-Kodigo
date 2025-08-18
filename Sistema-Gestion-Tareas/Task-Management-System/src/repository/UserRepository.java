package repository;

import model.User;

import java.util.UUID;

public interface UserRepository extends ReadRepository<User, UUID>, WriteRepository<User, UUID> { }