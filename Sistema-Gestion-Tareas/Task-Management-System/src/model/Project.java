package model;

import java.util.UUID;

public class Project {
    private final UUID id;
    private final String name;

    public Project(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
}
