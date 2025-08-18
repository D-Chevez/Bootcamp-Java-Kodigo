package service.filter;

import model.Project;
import model.Task;

public class ProjectSpecification implements Specification<Task> {
    private final Project project;

    public ProjectSpecification(Project project)
    {
        this.project = project;
    }

    @Override
    public boolean isSatisfiedBy(Task t)
    {
        return project.equals(t.getProject());
    }
}
