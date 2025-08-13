package service;

import model.Project;

import java.util.List;
import java.util.Optional;

/**
 * Business operations over projects.S
 */
public interface ProjectService {
    Project create(String name);
    Optional<Project> get(String id);
    List<Project> list();
}
