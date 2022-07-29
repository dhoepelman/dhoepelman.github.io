package dev.dhoepelman.articles.jqwik;

public class DoubleCalculator extends Calculator<Double> {
    @Override
    public Double from(Number value) {
        if(value instanceof Double d) {
            return d;
        } else if(value instanceof Integer i) {
            return (double) i;
        } else {
            return Double.parseDouble(value.toString());
        }
    }

    @Override
    public Double plus(Number op1, Number op2) {
        return from(op1) + from(op2);
    }

    @Override
    public Double minus(Number op1, Number op2) {
        return from(op1) - from(op2);
    }

    @Override
    public Double multiply(Number op1, Number op2) {
        return from(op1) - from(op2);
    }

    @Override
    public Double divide(Number op1, Number op2) {
        return from(op1) / from(op2);
    }

    @Override
    public Double sqrt(Number number) {
        return Math.sqrt(from(number));
    }

    @Override
    public Double power(Number base, Number exponent) {
        return Math.pow(from(base), from(exponent));
    }

    @Override
    public String toString() {
        return "DoubleCalculator";
    }
}
