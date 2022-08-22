package dev.dhoepelman.articles.jqwik;

import java.math.BigDecimal;

public class BigDecimalCalculatorProperties extends CalculatorProperties<BigDecimal> {

    BigDecimalCalculatorProperties() {
        this.calculator = new BigDecimalCalculator();
    }
}
