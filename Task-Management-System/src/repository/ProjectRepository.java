package repository;
import model.Project;

/** Aggregates the read/write contracts for projects. */
public interface ProjectRepository extends ReadRepository<Project>, WriteRepository<Project> { }