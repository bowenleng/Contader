package net.leng.math.functions;

public class MathFunction implements MathInput {
    private final MathInput a, b;
    private final BiOperators op;
    public MathFunction(MathInput a, MathInput b, BiOperators op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }

    @Override
    public double operate(double x) {
        return op.apply(a.operate(x), b.operate(x));
    }

    @Override
    public MathInput differentiate() {
        if (a instanceof MathConstant && b instanceof MathConstant) {
            return MathInput.val(0);
        }
        if (a instanceof MathConstant ac) {
            return switch (op) {
                case ADD -> b.differentiate();
                case SUBTRACT -> MathInput.func(b, MonoOperators.FLIP);
                case MULTIPLY -> ac;
                case DIVIDE -> MathInput.func(ac.flip(),
                        MathInput.func(b, MathInput.val(-2), BiOperators.POWER),
                        BiOperators.MULTIPLY);
                case POWER -> MathInput.func(
                        MathInput.func(
                                b.differentiate(),
                                MathInput.func(a, MonoOperators.LN),
                                BiOperators.MULTIPLY
                        ),
                        MathInput.func(a, b, BiOperators.POWER),
                        BiOperators.MULTIPLY
                );
                default -> this;
            };
        }
        if (b instanceof MathConstant bc) {
            return switch (op) {
                case ADD -> a.differentiate();
                case SUBTRACT -> MathInput.func(a, MonoOperators.FLIP);
                case MULTIPLY -> bc;
                case DIVIDE -> MathInput.func(bc, MonoOperators.INVERSE);
                case POWER -> MathInput.func(
                        b, MathInput.func(
                                a, bc.decrement(), BiOperators.POWER
                        ),
                        BiOperators.MULTIPLY
                );
                default -> this;
            };
        }
        return switch (op) {
            case ADD -> MathInput.func(a.differentiate(), b.differentiate(), BiOperators.ADD);
            case SUBTRACT -> MathInput.func(a.differentiate(), b.differentiate(), BiOperators.SUBTRACT);
            case MULTIPLY -> MathInput.func(
                    MathInput.func(a.differentiate(), b, BiOperators.MULTIPLY),
                    MathInput.func(a, b.differentiate(), BiOperators.MULTIPLY),
                    BiOperators.ADD
            );
            case DIVIDE -> MathInput.func(
                    MathInput.func(
                            MathInput.func(a.differentiate(), b, BiOperators.MULTIPLY),
                            MathInput.func(a, b.differentiate(), BiOperators.MULTIPLY),
                            BiOperators.SUBTRACT
                    ),
                    MathInput.func(b, MonoOperators.SQUARE),
                    BiOperators.DIVIDE
            );
            case POWER -> MathInput.func(
                    b, MathInput.func(
                            a, MathInput.func(b, MathInput.val(1), BiOperators.SUBTRACT),
                            BiOperators.POWER
                    ),
                    BiOperators.MULTIPLY
            );
            default -> this;
        };
    }

    @Override
    public String toString() {
        String as = a instanceof MathFunction ? "(" + a + ")" : a.toString();
        String bs = b instanceof MathFunction ? "(" + b + ")" : b.toString();
        return as + op.toString() + bs;
    }
}
