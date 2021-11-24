# Handle your data with Java Records

Keeping your data immutable has great benefits, making your code easier to reason about and preventing bugs.

Before Java 16, creating an immutable class for immutable data required a lot of boilerplate.
Lucky for us, Java 16 released a new "record" type to ease this common task.

A lot of ways have been developed to ease creating these classes, usually by generating code.
Well known examples are [Project Lombok](https://projectlombok.org/), [AutoValue](https://github.com/google/auto/tree/master/value) and [Immutables](https://immutables.github.io/).
In this blog post, we will show how to use Java records, and compare them mainly with Immutables.

Immutable data is frequently used for **serialization** and **deserialization**.
In this post, we will use [Jackson](https://github.com/FasterXML/jackson) for reading and writing JSON.

## Defining your data

## Comparison

|                | POJO  | Record | Immutables |
| -------------- | ----  | ------ | ---------- |
| Verbosity      | -     | +      | -          |
| Safety         | -     | +      | +          |
| Native support | +     | +      | -          |
| Default values | +     | ~      | +          |
| Derived values | +     | ~      | +          |
| Copying        | -     | -      | +          |
 
