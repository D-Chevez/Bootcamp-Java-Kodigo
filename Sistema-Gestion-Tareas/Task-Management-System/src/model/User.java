package model;

import java.util.UUID;

/**
 * Represents a system user.
 */
public class User {
    private final UUID id;
    private final String name;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }


}
