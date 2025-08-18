package service;

import model.Project;
import repository.ProjectRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ProjectServiceImp implements ProjectService {
    private final ProjectRepository repo;

    public ProjectServiceImp(ProjectRepository repo)
    {
        this.repo = Objects.requireNonNull(repo);
    }

    @Override
    public Project create(Project p)
    {
        return repo.save(p);
    }

    @Override
    public List<Project> findAll()
    {
        return repo.findAll();
    }

    @Override
    public void delete(UUID id)
    {
        repo.deleteById(id);
    }

    @Override
    public Optional<Project> findById(UUID id)
    {
        return repo.findById(id);
    }
}
