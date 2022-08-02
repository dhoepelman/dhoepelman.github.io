#### How to use records

Using a record is almost exactly like using an immutable POJO, you create it using a constructor:

```java
var customer = new Customer(UUID.randomUUID(), "John");
```

Retrieving the data is still using getters, which are the same as the field names.
Note that Javabean conventions are not used, so a getter is called `x()` and not `getX()`.

```java
var name = customer.name();
```

##### Javadoc

Documentation for records and components uses the existing `@param` javadoc tag:

```java
/**
* Documentation of the Customer class.
* @param id customer id
* @param name customer name
*/
record Customer(UUID id, String name) {}
```

##### Modifying records

Unfortunately records are not as easy to modify as their equivalents in other languages.
The best you can do is either to manually add `with`-er or a `copy` method,
or use an annotation processor to provide this functionality such as [record-builder](https://github.com/randgalt/record-builder).

```java
record Customer(UUID id, String name) {
    Customer withName(String name) {
        return new Customer(id, name);
    }
}
```

This will likely be improved in a future version of Java.
There is no definitive verdict yet, but [in June 2022 the language designers were considering this syntax](https://mail.openjdk.org/pipermail/amber-spec-experts/2022-June/003461.html):

```java
var renamed = customer with { name = "newName"; }
```

##### Default values

Constructors can have additional constructors, next to their *canonical* constructor that has the same parameters as the components.
This can be useful to set default values for some fields.

```java
record Customer(UUID id, String name) {
    /** Create a new customer with a fresh id. */
    public Customer(String name) {
        this(UUID.randomUUID(), name);
    }
}
```

##### Validation

A data holder might have some checks to prevent invalid objects from being created.
Often these are put into the constructor of a POJO:

```java
class CustomerPOJO {
    public CustomerPOJO(UUID id, String name) {
        if(name.isBlank()) {
          throw new IllegalArgumentException("name cannot be null or blank");
        }
        this.id = id;
        this.name = name;
    }
}
```

Records provide a special construct called a compact constructor for this.
They work similar to a normal constructors, but you don't need to specify parameters or set the components:

```java
record Customer(UUID id, String name) {
    Customer {
        if(name.isBlank()) {
          throw new IllegalArgumentException("name cannot be null or blank");
        }
    }
}
```

##### Normalization

Besides validations, you can also modify data in a compact constructor.
This  is useful to normalize your record:

```java
record Customer(UUID id, String name) {
    Customer {
        name = name.trim();
    }
}
```

##### Enforcing non-nullability

Records do not have any special behavior regarding nullability of components.
You can use tools like [NullAway](https://github.com/uber/NullAway) or [Error Prone](https://errorprone.info/) to prevent `null` in your code in general, or you can add checks to your records:

```java
record Customer(UUID id, String name) {
    Customer {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
    }
}
```

#### Derived data

Sometimes, you need to use the primary pieces of data in a record to derive something new, just like with POJOs, you can simply add a method:

```java
record Customer(String firstName, String lastName) {
    String fullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
```
