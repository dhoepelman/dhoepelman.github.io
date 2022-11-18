#### Records and Jackson

Jackson is a popular library to serialize Java objects to JSON, and since version 2.12 it also supports records!
Let's see how we can use it.

#### Reading or writing a record

Records are supported out of the box since Jackson 2.12, and work just as their equivalent POJO

```java
record Customer(UUID id, String firstName) {}
```

can be read from or written as

```json
{
  "id": "7fe05925-18d8-4284-a15c-8af6f33f1d6e",
  "firstName": "John"
}
```

All normal Jackson options and configuration will be respected.

#### Annotations like JsonAlias, JsonValue or 

TODO: describe BUG

#### Leaving out components

#### Adding additional data to serialized JSON

#### Default values

#### Validation

#### Normalization



