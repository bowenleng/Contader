package net.leng.math.functions;

import java.util.function.BiFunction;

public enum BiOperators {
    ADD(Double::sum, "+"),
    SUBTRACT((a, b) -> a - b, "-"),
    MULTIPLY((a, b) -> a * b, "*"),
    DIVIDE((a, b) -> a / b, "/"),
    POWER(Math::pow, "^"),
    REMAINDER((a, b) -> a % b, "r");
    private final BiFunction<Double, Double, Double> function;
    private final String symbol;
    BiOperators(BiFunction<Double, Double, Double> fun, String sym) {
        function = fun;
        symbol = sym;
    }
    public double apply(double a, double b) {
        return function.apply(a, b);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
