package repository;
import model.Project;

import java.util.UUID;

public interface ProjectRepository extends ReadRepository<Project, UUID>, WriteRepository<Project, UUID> { }