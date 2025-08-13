package service;

import model.Task;
import model.TaskStatus;
import model.Priority;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Business operations over tasks.
 */
public interface TaskService {
    Task create(String title, String description, LocalDate dueDate, Priority priority);
    Optional<Task> get(String id);
    List<Task> list();
    void assignToProject(String taskId, String projectId);
    void assignToUser(String taskId, String userId);
    void move(String taskId, TaskStatus status);
    List<Task> filter(TaskFilter filter);
}
