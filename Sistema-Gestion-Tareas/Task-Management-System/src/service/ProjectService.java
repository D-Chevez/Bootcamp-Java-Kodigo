package service;

import model.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectService {
    Project create(Project p);
    List<Project> findAll();
    void delete(UUID id);
    Optional<Project> findById(UUID id);
}
