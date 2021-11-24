# Immutability in Java: Records vs Immutables

// Base format on https://blog.bam.tech/developer-news/should-you-use-enums-or-union-types-in-typescript

Keeping your data immutable has great benefits, making your code easier to reason about and preventing bugs.

Before Java 16, creating an immutable class for immutable data required a lot of boilerplate.
Lucky for us, Java 16 released a new "record" type to ease this common task.

A lot of ways have been developed to ease creating these classes, usually by generating code.
Well known examples are [Project Lombok](https://projectlombok.org/), [AutoValue](https://github.com/google/auto/tree/master/value) and [Immutables](https://immutables.github.io/).
In this blog post, we will show how to use Java records, and compare them mainly with Immutables.

Immutable data is frequently used for **serialization** and **deserialization**.
In this post, we will use 

## Why use immutable data?

* **Safety**: Using immutable data eliminates whole classes of bugs from your code, and they can safely be shared without making defensive copies or synchronization.
* **Reasoning**: once constructed an immutable object can never be changed, making your programs easier to reason about because object behavior is determinitic and stateless 
* **(De)serialization**: immutable objects are safe representations of data you need to read and write. Here we will be using [Jackson](https://github.com/FasterXML/jackson) for reading and writing JSON.  

## Defining your data

Java has a reputation for being verbose. Luckily, records provide an elegant and compact way to define your data:
```java
public record Product(int id, String name, double price, Optional<Promotion> promo, List<Store> stores) {}
```

Immutables isn't bad either, especially compared to POJO's, but records are the clear winner here:
```java
@Value.Immutable
public interface Product {
  int getId();
  String getName();
  double getPrice();
  Optional<Promotion> getPromo();
  List<Store> getStores();
}
```

Since you can't directly use this interface, Immutables needs to create a generated class for the "real" implementation you're going to use:
```java
@Generated(from = "Product", generator = "Immutables")
@Immutable
public final class ImmutableProduct implements Product {
    /* Lots of generated code here */
}
```

**1 point for records!** Immutables gets a **0.5 point penalty** for having to deal with 2 types.

## Creating and using your data

Records piggyback on existing syntax for classes, create one just like a normal class:
```java
Product product = new Product(1, "Cookies", 1.5, Optional.empty(), List.of());
```

Immutables creates a factory method you can use:
```java
ImmutableProduct product = ImmutableProduct.of(1, "Cookies", 1.5, Optional.empty(), List.of());
```

In addition, a builder is created, which is especially useful if you have lots of optional fields:
```java
ImmutableProduct product = ImmutableProduct.builder()
  .id(1),
  .name("Cookies")
  .price(1.5)
  .build();
``` 

Unfortunately, it's less compile-time safe than using `of()`, since `build()` will throw at runtime if you forgot a mandatory field.

**Both get 1 point!** Immutables gets **0.5 bonus points** for the builder.

## Copying 

Programming is all about transforming data. In practice, it's often useful to create a modified copy of some immutable data.

Records don't provide any special support for this use case, [yet](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2020-July/002236.html):
```java
Product promoProduct = new Product(
    product.getId(),
    product.getName(),
    product.getPrice(),
    database.findActivePromotion(product.getId()),
    product.getStores(),
);
``` 

Immutables provides both a `.copyOf()` method which you'll rarely need, and much more useful "wither" methods:

```java
ImmutableProduct promoProduct = product
  .withPromo(database.findActivePromotion(product.getId()));
```

No contest from records here, **1 point for Immutables**.

## Validation and normalization

Records 



## Optional fields



## Comparison

|                | POJO  | Record | Immutables |
| -------------- | ----  | ------ | ---------- |
| Verbosity      | -     | +      | -          |
| Safety         | -     | +      | +          |
| Native support | +     | +      | -          |
| Default values | +     | ~      | +          |
| Derived values | +     | ~      | +          |
| Copying        | -     | -      | +          |
 
