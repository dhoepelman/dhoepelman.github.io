package blog.records;

import java.util.Objects;
import java.util.UUID;

record CustomerNormalize(UUID id, String name) {
    CustomerNormalize {
        name = name.trim();
    }
}
