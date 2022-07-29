package dev.dhoepelman.articles.jqwik;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CommutativeTest {

    static Calculator<?>[] calculators() {
        return new Calculator<?>[] {new DoubleCalculator(), new BigDecimalCalculator()};
    }

    @ParameterizedTest
    @MethodSource("calculators")
    void sumIsCommutative(Calculator<?> calc) {
        var args = List.of(1,2,3,4);
        var result1 = calc.sum(args);
        var result2 = calc.sum(Lists.reverse(args));
        assertThat(result1).isEqualTo(result2);
    }
}
