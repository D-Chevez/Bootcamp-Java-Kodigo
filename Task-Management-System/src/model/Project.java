package model;

/**
 * Represents a project that groups tasks.
 */
public class Project {
    private final String id;
    private final String name;

    public Project(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}
