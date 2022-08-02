package blog.records;

import java.util.Objects;
import java.util.UUID;

record CustomerValid(UUID id, String name) {
    CustomerValid {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        Objects.requireNonNull(id, "id cannot be null");
    }
}
