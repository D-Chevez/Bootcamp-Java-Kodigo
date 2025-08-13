package repository;

import model.User;

/** Aggregates the read/write contracts for users. */
public interface UserRepository extends ReadRepository<User>, WriteRepository<User> { }