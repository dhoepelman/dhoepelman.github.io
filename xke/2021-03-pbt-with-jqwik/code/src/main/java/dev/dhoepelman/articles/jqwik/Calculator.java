package dev.dhoepelman.articles.jqwik;

import java.util.*;

public abstract class Calculator<T extends Number> {
	private final T ZERO = from(0);

	protected abstract T from(Number value);

	abstract T plus(T op1, T op2);
	abstract T minus(T op1, T op2);
	abstract T multiply(T op1, T op2);
	abstract T divide(T op1, T op2);

	abstract T sqrt(T number);
	abstract T power(T base, T exponent);

	T sum(List<? extends Number> operands) {
		return operands.stream().map(this::from).reduce(ZERO, this::plus);
	}
}
