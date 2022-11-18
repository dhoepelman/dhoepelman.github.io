package blog.jackson;

import com.fasterxml.jackson.annotation.JsonValue;

public record Money(@JsonValue int cents) {
}
