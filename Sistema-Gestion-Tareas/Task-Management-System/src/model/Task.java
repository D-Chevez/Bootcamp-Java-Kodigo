package model;

import java.time.LocalDate;
import java.util.UUID;

public class Task extends WorkItem {
    private TaskStatus status;
    private Priority priority;
    private User assignee;
    private Project project;

    public Task(String title, String description) {
        super(title, description);
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public User getAssignee() {
        return assignee;
    }

    public Project getProject() {
        return project;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}