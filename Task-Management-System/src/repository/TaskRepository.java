package repository;

import model.Task;

import java.util.List;

/** Adds task-specific queries. Open for extension via default methods in impls. */
public interface TaskRepository extends ReadRepository<Task>, WriteRepository<Task> {
    List<Task> findByProjectId(String projectId);
    List<Task> findByAssigneeUserId(String userId);
}