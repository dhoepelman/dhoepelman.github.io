package blog.immutables;

import org.immutables.value.Value;

@Value.Immutable
public interface TestInterface extends WithTestInterface {
    String getName();
}
