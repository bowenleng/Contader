package net.leng.math.functions;

import net.leng.math.SuppMath;

import java.util.function.Function;

public enum MonoOperators {
    ABS(Math::abs, "|%s|"),
    ACOS(Math::acos, "arccos(%s)"),
    ASIN(Math::asin, "arcsin(%s)"),
    ATAN(Math::atan, "arctan(%s)"),
    CBRT(Math::cbrt, "∛(%s)"),
    COT(x -> Math.cos(x) / Math.sin(x), "cot(%s)"),
    COTH(SuppMath::coth, "coth(%s)"),
    COS(Math::cos, "cos(%s"),
    COSH(Math::cosh, "cosh(%s)"),
    CSC(x -> 1/Math.sin(x), "csc(%s)"),
    CSCH(SuppMath::csch, "csch(%s)"),
    EXP(Math::exp, "e^(%s)"),
    FLIP(x -> -x, "-(%s)"),
    INVERSE(x -> 1/x, "1/(%s)"),
    LN(Math::log, "ln(%s)"),
    LOG2(x -> Math.log(x) / Math.log(2), "log2(%s)"),
    LOG10(Math::log10, "log10(%s)"),
    SEC(x -> 1 / Math.cos(x), "sec(%s)"),
    SECH(SuppMath::sech, "sech(%s)"),
    SIN(Math::sin, "sin(%s)"),
    SINH(Math::sinh, "sinh(%s)"),
    SQRT(Math::sqrt, "√(%s)"),
    SQUARE(x -> x * x, "(%s)²"),
    TAN(Math::tan, "tan(%s)"),
    TANH(Math::tanh, "tanh(%s)");
    private final Function<Double, Double> function;
    private final String symbol;
    MonoOperators(Function<Double, Double> fun, String sym) {
        function = fun;
        symbol = sym;
    }

    public double apply(double x) {
        return function.apply(x);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
