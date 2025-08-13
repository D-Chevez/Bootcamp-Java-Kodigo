package service;

import model.Project;
import repository.ProjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProjectServiceImp implements ProjectService {
    private final ProjectRepository projects;

    public ProjectServiceImp(ProjectRepository projects) {
        this.projects = projects;
    }

    @Override
    public Project create(String name) {
        Project p = new Project(UUID.randomUUID().toString(), name);
        projects.save(p);
        return p;
    }

    @Override
    public Optional<Project> get(String id) {
        return projects.findById(id);
    }

    @Override
    public List<Project> list() {
        return projects.findAll();
    }
}
