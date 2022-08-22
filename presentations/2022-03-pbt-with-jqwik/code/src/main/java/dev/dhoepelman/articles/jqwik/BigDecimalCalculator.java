package dev.dhoepelman.articles.jqwik;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalCalculator extends Calculator<BigDecimal>{

    private static final MathContext ctx = MathContext.UNLIMITED;

    @Override
    public BigDecimal from(Number value) {
        if(value instanceof BigDecimal v) {
            return v;
        } else if(value instanceof Integer v) {
            return BigDecimal.valueOf(v);
        } else if (value instanceof Double v) {
            return BigDecimal.valueOf(v);
        } else {
            return new BigDecimal(value.toString());
        }
    }

    @Override
    public BigDecimal plus(Number op1, Number op2) {
        return from(op1).add(from(op2));
    }

    @Override
    public BigDecimal minus(Number op1, Number op2) {
        return from(op1).subtract(from(op2));
    }

    @Override
    public BigDecimal multiply(Number op1, Number op2) {
        return from(op1).multiply(from(op2));
    }

    @Override
    public BigDecimal divide(Number op1, Number op2) {
        return from(op1).divide(from(op2), RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal sqrt(Number number) {
        return from(number).sqrt(ctx);
    }

    @Override
    public BigDecimal power(Number base, Number exponent) {
        return null;
    }

    @Override
    public String toString() {
        return "BigDecimalCalculator";
    }
}
