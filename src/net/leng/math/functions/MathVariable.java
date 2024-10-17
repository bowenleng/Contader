package net.leng.math.functions;

public class MathVariable implements MathInput {
    private final double coefficient;
    public MathVariable() {
        this(1);
    }
    public MathVariable(double coef) {
        coefficient = coef;
    }
    @Override
    public double operate(double x) {
        return x;
    }

    @Override
    public MathInput differentiate() {
        return new MathConstant(coefficient);
    }

    @Override
    public String toString() {
        return coefficient == 1 ? "x" : coefficient + "x";
    }
}
