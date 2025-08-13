package model;

import java.time.LocalDate;

public class Task extends WorkItem {
    private TaskStatus status;
    private Priority priority;
    private String projectId; // optional
    private String assigneeUserId; // optional

    public Task(String id, String title, String description, LocalDate dueDate,
                Priority priority) {
        super(id, title, description, dueDate);
        this.priority = priority;
        this.status = TaskStatus.TODO;
    }

    public TaskStatus getStatus() { return status; }
    public Priority getPriority() { return priority; }
    public String getProjectId() { return projectId; }
    public String getAssigneeUserId() { return assigneeUserId; }

    public void setPriority(Priority priority) { this.priority = priority; }
    public void moveTo(TaskStatus newStatus) { this.status = newStatus; }
    public void assignToProject(String projectId) { this.projectId = projectId; }
    public void assignToUser(String userId) { this.assigneeUserId = userId; }
}