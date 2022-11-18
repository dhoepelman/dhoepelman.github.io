package blog.records;

public record CustomerDerived (String firstName, String lastName) {
    // This will give a compile error, records are not allowed to have instance fields
    // private final String fullName = String.format("%s %s", firstName, lastName)
}
