# Records in Java
### And how to use them for different use-cases


#### Introduction

Records were introduced as a stable language features in Java 16, but what are they, and what can you use them for?

One of the most frequent tasks in programming is passing some set of unchanging data from one place to the next,
and transforming it into some other data, but before Java 16 defining such a set of data was quite verbose.
Let's take a look at how records make this mundane task so much easier!

##### What are records?

Records can be thought of as a replacement for <abbr title="Plain Old Java Object, simple data holders">POJO</abbr>s.
These holders usually have one or more of the following properties:

* They are defined solely by the data they contain
* They have an `equals()` and `hashCode()` method based solely on their data
* For each piece of data they have
  * A private final field
  * A getter
  * A constructor parameter
  * The field is either non-null or `Optional`
* They have a `toString()` that shows all the data
* They are converted to and from a data format like JSON, using a library like [Jackson](https://github.com/FasterXML/jackson).

Here is a minimal example of such a POJO:
```java
final class Customer {
    private final UUID id;
    private final String name;

    public Customer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public UUID getId() {
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
```

Now let's see the equivalent record implementation:
```java
record Customer(String id, String name) {}
```

Need we say more? Thank you for reading this far. You can now stop reading and start using records everywhere,
or you can continue on to [part 2: how you use records in practice](blog-02-record-use-cases.md).
