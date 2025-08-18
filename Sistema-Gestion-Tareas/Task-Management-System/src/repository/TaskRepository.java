package repository;

import model.Task;

import java.util.UUID;

public interface TaskRepository extends ReadRepository<Task, UUID>, WriteRepository<Task, UUID> {

}