package service.filter;

import model.Task;
import model.User;

public class AssigneeSpecification implements Specification<Task> {
    private final User user;

    public AssigneeSpecification(User user)
    {
        this.user = user;
    }

    @Override
    public boolean isSatisfiedBy(Task t)
    {
        return user.equals(t.getAssignee());
    }
}
