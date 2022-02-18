package dev.dhoepelman.articles.jqwik;

import java.math.BigDecimal;
import java.util.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.assertj.core.api.*;

import static java.util.Arrays.*;

abstract class CalculatorProperties<T extends Number> {

	protected Calculator<T> calculator;

	@Property
	boolean sumIsPositive(@ForAll @Size(min = 1, max = 10) List<@IntRange(min = 1, max = 1000) Integer> operands) {
		var result = new BigDecimalCalculator().sum(operands);
		return result.compareTo(BigDecimal.ZERO) > 0;
	}

	@Property
	void addingZeroIsNoop(@ForAll BigDecimal number) {
		var result = new BigDecimalCalculator().sum(asList(number, 0));
		Assertions.assertThat(result).isEqualTo(number);
	}
}
