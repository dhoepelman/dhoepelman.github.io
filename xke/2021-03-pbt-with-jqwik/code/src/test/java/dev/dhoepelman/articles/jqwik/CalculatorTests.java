package dev.dhoepelman.articles.jqwik;

import java.math.BigDecimal;
import java.util.List;
import net.jqwik.api.*;
import org.assertj.core.api.*;

import static java.util.Arrays.*;

class CalculatorTests {

	@Example
	void summingUpZeros() {
		var result = new BigDecimalCalculator().sum(List.of(0, 0, 0));
		Assertions.assertThat(result).isEqualTo(BigDecimal.valueOf(0));
	}

	@Example
	void summingUpTwoNumbers() {
		var result = new BigDecimalCalculator().sum(List.of(1, 41));
		Assertions.assertThat(result).isEqualTo(BigDecimal.valueOf(42));
	}
}
