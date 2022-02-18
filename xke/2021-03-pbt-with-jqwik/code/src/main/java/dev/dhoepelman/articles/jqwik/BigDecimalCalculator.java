package dev.dhoepelman.articles.jqwik;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalCalculator extends Calculator<BigDecimal>{

    private static final MathContext ctx = MathContext.UNLIMITED;

    @Override
    protected BigDecimal from(Number value) {
        if(value instanceof BigDecimal v) {
            return v;
        } else if(value instanceof Integer v) {
            return BigDecimal.valueOf(v);
        } else {
            return new BigDecimal(value.toString());
        }
    }

    @Override
    public BigDecimal plus(BigDecimal op1, BigDecimal op2) {
        return op1.add(op2);
    }

    @Override
    public BigDecimal minus(BigDecimal op1, BigDecimal op2) {
        return op1.subtract(op2);
    }

    @Override
    public BigDecimal multiply(BigDecimal op1, BigDecimal op2) {
        return op1.multiply(op2);
    }

    @Override
    public BigDecimal divide(BigDecimal op1, BigDecimal op2) {
        return op1.divide(op2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal sqrt(BigDecimal number) {
        return number.sqrt(ctx);
    }

    @Override
    public BigDecimal power(BigDecimal base, BigDecimal exponent) {
        return null;
    }
}
