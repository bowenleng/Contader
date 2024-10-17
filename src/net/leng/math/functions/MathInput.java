package net.leng.math.functions;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface MathInput {
    double operate(double x);
    MathInput differentiate();
    // MathFunction integration(double start, double end);

    @Contract(value = "_ -> new", pure = true)
    static @NotNull MathInput val(double c) {
        return new MathConstant(c);
    }

    @Contract(value = " -> new", pure = true)
    static @NotNull MathInput var() {
        return new MathVariable();
    }

    @Contract(value = "_, _ -> new", pure = true)
    static @NotNull MathInput func(MathInput in, MonoOperators op) {
        return new MathSoloFunction(in, op);
    }

    @Contract("_, _, _ -> new")
    static @NotNull MathInput func(MathInput a, MathInput b, BiOperators op) {
        return new MathFunction(a, b, op);
    }
}
