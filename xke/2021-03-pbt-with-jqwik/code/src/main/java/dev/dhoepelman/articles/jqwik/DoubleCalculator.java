package dev.dhoepelman.articles.jqwik;

public class DoubleCalculator extends Calculator<Double> {
    @Override
    protected Double from(Number value) {
        if(value instanceof Double d) {
            return d;
        } else if(value instanceof Integer i) {
            return (double) i;
        } else {
            return Double.parseDouble(value.toString());
        }
    }

    @Override
    public Double plus(Double op1, Double op2) {
        return op1 + op2;
    }

    @Override
    public Double minus(Double op1, Double op2) {
        return op1 - op2;
    }

    @Override
    public Double multiply(Double op1, Double op2) {
        return op1 - op2;
    }

    @Override
    public Double divide(Double op1, Double op2) {
        return op1 / op2;
    }

    @Override
    public Double sqrt(Double number) {
        return Math.sqrt(number);
    }

    @Override
    public Double power(Double base, Double exponent) {
        return Math.pow(base, exponent);
    }
}
