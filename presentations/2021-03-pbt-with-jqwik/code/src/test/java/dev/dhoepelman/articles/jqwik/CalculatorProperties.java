package dev.dhoepelman.articles.jqwik;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.assertj.core.api.*;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.assertThat;

abstract class CalculatorProperties<T extends Number> {

	protected Calculator<T> calculator;

	private BigDecimal bd(T value) {
		return new BigDecimal(value.toString());
	}

	private T from(Number value) {
		return calculator.from(value);
	}

	@Property
	void addingZeroIsNoop(@ForAll Double number) {
		var result = calculator.sum(asList(number, 0));
		assertThat(result).isEqualTo(from(number));
	}

	@Property
	void sumOfPositiveIsPositive(@ForAll @Size(min = 1, max = 10) List<@Positive Double> operands) {
		var result = calculator.sum(operands);
		assertThat(bd(result)).isGreaterThanOrEqualTo(BigDecimal.ZERO);
	}

	@Property
	void plusIsCommutative(@ForAll Double op1, @ForAll Double op2) {
		var result1 = calculator.plus(op1, op2);
		var result2 = calculator.plus(op2, op1);
		assertThat(result1).isEqualTo(result2);
	}

	@Property
	void sumIsCommutative(@ForAll @Size(min = 2, max = 10) List<Double> operands) {
		var result1 = calculator.sum(operands);
		var result2 = calculator.sum(Lists.reverse(operands));
		assertThat(result1).isEqualTo(result2);
	}
}
