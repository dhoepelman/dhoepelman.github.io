package blog.pojo;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

public final class Customer {
    private final String id;
    private final String name;

    public Customer(String id, String name) {
        this.id = requireNonNull(id);
        this.name = requireNonNull(name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer[id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
