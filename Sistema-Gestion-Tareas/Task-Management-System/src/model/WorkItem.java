package model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Represents a generic unit of work in the system.
 */
public abstract class WorkItem {
    protected final UUID id;
    protected final String title;
    protected String description;
    protected LocalDate dueDate;

    protected WorkItem(String title, String description) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
