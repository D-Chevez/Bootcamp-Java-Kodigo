package service;

import model.Task;
import repository.TaskRepository;
import service.filter.TaskFilter;
import service.filter.Specification;
import service.filter.StatusSpecification;

import java.util.*;

public class TaskServiceImp implements TaskService {
    private final TaskRepository repo;

    public TaskServiceImp(TaskRepository repo) {
        this.repo = Objects.requireNonNull(repo); // Dependency Inversion via constructor
    }

    @Override public Task create(Task task)
    {
        return repo.save(task);
    }

    @Override public Task update(Task task)
    {
        return repo.save(task);
    }

    @Override public void delete(UUID id)
    {
        repo.deleteById(id);
    }

    @Override public List<Task> findAll()
    {
        return repo.findAll();
    }

    @Override
    public List<Task> findByFilter(TaskFilter f) {
        // Build a composite Specification (Open/Closed for new criteria)
        Specification<Task> spec = candidate -> true;
        if (f.status.isPresent())   spec = spec.and(new StatusSpecification(f.status.get()));
        if (f.assignee.isPresent()) spec = spec.and(t -> f.assignee.get().equals(t.getAssignee()));
        if (f.project.isPresent())  spec = spec.and(t -> f.project.get().equals(t.getProject()));
        if (f.dueFrom.isPresent())  spec = spec.and(t -> t.getDueDate() != null && !t.getDueDate().isBefore(f.dueFrom.get()));
        if (f.dueTo.isPresent())    spec = spec.and(t -> t.getDueDate() != null && !t.getDueDate().isAfter(f.dueTo.get()));

        List<Task> out = new ArrayList<>();
        for (Task t : repo.findAll()) if (spec.isSatisfiedBy(t)) out.add(t);
        return out;
    }

    @Override
    public Optional<Task> findById(UUID id)
    {
        return repo.findById(id);
    }
}
