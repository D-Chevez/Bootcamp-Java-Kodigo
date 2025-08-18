package service.filter;

import model.Task;
import model.TaskStatus;

public class StatusSpecification implements Specification<Task> {
    private final TaskStatus expected;

    public StatusSpecification(TaskStatus expected)
    {
        this.expected = expected;
    }

    @Override
    public boolean isSatisfiedBy(Task t)
    {
        return t.getStatus() == expected;
    }
}