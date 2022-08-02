package blog.records;

import java.util.UUID;

record CustomerWith(UUID id, String name) {
    CustomerWith withName(String name) {
        return new CustomerWith(id, name);
    }
}
