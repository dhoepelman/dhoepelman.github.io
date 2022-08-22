package blog.records;

public record CustomerDerived (String firstName, String lastName) {
    private final String fullName = "";
}
