package service;

import model.Task;
import service.filter.TaskFilter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    Task create(Task task);
    Task update(Task task);
    void delete(UUID id);
    List<Task> findAll();
    List<Task> findByFilter(TaskFilter filter);
    Optional<Task> findById(UUID id);
}
