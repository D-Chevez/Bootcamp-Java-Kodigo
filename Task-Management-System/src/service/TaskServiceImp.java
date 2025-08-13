package service;

import model.Priority;
import model.Task;
import model.TaskStatus;
import repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaskServiceImp implements TaskService{
    private final TaskRepository tasks;

    public TaskServiceImp(TaskRepository tasks) {
        this.tasks = tasks;
    }

    // TODO: Implement the create method to save a new task
    @Override
    public Task create(String title, String description, LocalDate dueDate, Priority priority) {
        return null;
    }

    // TODO: Implement the get method to retrieve a task by its ID
    @Override
    public Optional<Task> get(String id) {
        return Optional.empty();
    }

    // TODO: Implement the list method to return all tasks
    @Override
    public List<Task> list() {
        return List.of();
    }

    // TODO: Implement the update method to modify an existing task
    @Override
    public void assignToProject(String taskId, String projectId) {

    }

    // TODO: Implement the assignToUser method to assign a task to a user
    @Override
    public void assignToUser(String taskId, String userId) {

    }

    // TODO: Implement the move method to change the status of a task
    @Override
    public void move(String taskId, TaskStatus status) {

    }

    // TODO: Implement the filter method to return tasks based on a filter
    @Override
    public List<Task> filter(TaskFilter filter) {
        return List.of();
    }
}
