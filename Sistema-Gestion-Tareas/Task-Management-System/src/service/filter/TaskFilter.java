package service.filter;

import model.Project;
import model.Task;
import model.TaskStatus;
import model.User;

import java.time.LocalDate;
import java.util.Optional;

public final class TaskFilter {
    public Optional<TaskStatus> status = Optional.empty();
    public Optional<User> assignee = Optional.empty();
    public Optional<Project> project = Optional.empty();
    public Optional<LocalDate> dueFrom = Optional.empty();
    public Optional<LocalDate> dueTo = Optional.empty();
}