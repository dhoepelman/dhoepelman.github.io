package blog.records;

import java.util.UUID;

public record CustomerDefault(UUID id, String name) {
    /** Create a new customer with a fresh id. */
    public CustomerDefault(String name) {
        this(UUID.randomUUID(), name);
    }
}
