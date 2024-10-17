package net.leng.math.functions;

public class MathConstant implements MathInput {
    private final double val;
    public MathConstant(double val) {
        this.val = val;
    }
    @Override
    public double operate(double x) {
        return val;
    }

    public MathConstant flip() {
        return new MathConstant(-val);
    }

    public MathConstant decrement() {
        return new MathConstant(val - 1);
    }

    public MathConstant increment() {
        return new MathConstant(val + 1);
    }

    public MathConstant change(double num) {
        return new MathConstant(val + num);
    }

    public MathConstant invert() {
        return new MathConstant(1 / val);
    }

    @Override
    public MathInput differentiate() {
        return new MathConstant(0);
    }

    @Override
    public String toString() {
        return Double.toString(val);
    }
}
