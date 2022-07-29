package dev.dhoepelman.articles.jqwik;

import java.util.*;

public abstract class Calculator<T extends Number> {
	private final T ZERO = from(0);

	public abstract T from(Number value);

	abstract T plus(Number op1, Number op2);
	T sum(List<? extends Number> operands) {
		return operands.stream().map(this::from).reduce(ZERO, this::plus);
	}

	abstract T minus(Number op1, Number op2);
	abstract T multiply(Number op1, Number op2);
	abstract T divide(Number op1, Number op2);

	abstract T sqrt(Number number);
	abstract T power(Number base, Number exponent);

}
