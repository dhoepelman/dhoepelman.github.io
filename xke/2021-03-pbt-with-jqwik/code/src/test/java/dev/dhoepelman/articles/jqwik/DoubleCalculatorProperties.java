package dev.dhoepelman.articles.jqwik;


public class DoubleCalculatorProperties extends CalculatorProperties<Double> {

    DoubleCalculatorProperties() {
        this.calculator = new DoubleCalculator();
    }
}
