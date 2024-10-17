package net.leng.math.functions;

public class MathSoloFunction implements MathInput {
    private final MonoOperators op;
    private final MathInput in;
    public MathSoloFunction(MathInput in, MonoOperators op) {
        this.in = in;
        this.op = op;
    }
    @Override
    public double operate(double x) {
        return op.apply(in.operate(x));
    }

    @Override
    public MathInput differentiate() {
        if (in instanceof MathConstant) return MathInput.val(0);
        MathInput oneDer = switch (op) {
            case ABS -> MathInput.func(in, MathInput.func(in, MonoOperators.ABS), BiOperators.DIVIDE);
            case ACOS -> MathInput.func(MathInput.val(-1),
                    MathInput.func(
                            MathInput.func(
                                    MathInput.val(1), MathInput.func(in, MonoOperators.SQUARE),
                                    BiOperators.SUBTRACT),
                            MonoOperators.SQRT),
                    BiOperators.DIVIDE);
            case ASIN -> MathInput.func(MathInput.val(1),
                    MathInput.func(
                            MathInput.func(
                                    MathInput.val(1), MathInput.func(in, MonoOperators.SQUARE),
                                    BiOperators.SUBTRACT),
                            MonoOperators.SQRT),
                    BiOperators.DIVIDE);
            case ATAN -> MathInput.func(MathInput.val(1),
                    MathInput.func(
                            MathInput.val(1), MathInput.func(in, MonoOperators.SQUARE),
                            BiOperators.ADD),
                    BiOperators.DIVIDE);
            case CBRT -> MathInput.func(
                    MathInput.func(in, MathInput.val(-2d/3d), BiOperators.POWER),
                    MathInput.val(1d/3d),
                    BiOperators.MULTIPLY);
            case COT -> MathInput.func(
                            MathInput.func(
                                    MathInput.func(in, MonoOperators.CSC),
                                    MonoOperators.SQUARE),
                            MonoOperators.FLIP);
            case COTH -> MathInput.func(
                    MathInput.func(
                            MathInput.func(in, MonoOperators.CSCH),
                            MonoOperators.SQUARE
                    ),
                    MonoOperators.FLIP
            );
            case COS -> MathInput.func(
                    MathInput.func(in, MonoOperators.SIN),
                    MonoOperators.FLIP
            );
            case COSH -> MathInput.func(in, MonoOperators.SINH);
            case CSC -> MathInput.func(
                    MathInput.func(
                            MathInput.func(in, MonoOperators.CSC),
                            MathInput.func(in, MonoOperators.COS),
                            BiOperators.MULTIPLY
                    ),
                    MonoOperators.FLIP
            );
            case CSCH -> MathInput.func(
                    MathInput.func(
                            MathInput.func(in, MonoOperators.CSCH),
                            MathInput.func(in, MonoOperators.COSH),
                            BiOperators.MULTIPLY
                    ),
                    MonoOperators.FLIP
            );
            case EXP -> MathInput.func(
                    in.differentiate(),
                    MathInput.func(in, MonoOperators.EXP),
                    BiOperators.MULTIPLY
            );
            case FLIP -> MathInput.func(in.differentiate(), MonoOperators.FLIP);
            case INVERSE -> MathInput.func(
                    MathInput.func(in, MathInput.val(-2), BiOperators.POWER),
                    MonoOperators.FLIP);
            case LN -> MathInput.func(in.differentiate(), in, BiOperators.DIVIDE);
            case LOG2 -> MathInput.func(
                    in.differentiate(),
                    MathInput.func(in, MathInput.val(Math.log(2)), BiOperators.MULTIPLY),
                    BiOperators.DIVIDE
            );
            case LOG10 -> MathInput.func(
                    in.differentiate(),
                    MathInput.func(in, MathInput.val(Math.log(10)), BiOperators.MULTIPLY),
                    BiOperators.DIVIDE
            );
            case SEC -> MathInput.func(
                    MathInput.func(in, MonoOperators.SEC),
                    MathInput.func(in, MonoOperators.TAN),
                    BiOperators.MULTIPLY
            );
            case SECH -> MathInput.func(
                    MathInput.func(
                            MathInput.func(in, MonoOperators.SECH),
                            MathInput.func(in, MonoOperators.TANH),
                            BiOperators.MULTIPLY
                    ),
                    MonoOperators.FLIP
            );
            case SIN -> MathInput.func(in, MonoOperators.COS);
            case SINH -> MathInput.func(in, MonoOperators.COSH);
            case SQRT -> MathInput.func(
                    MathInput.val(0.5), MathInput.func(in, MathInput.val(-0.5), BiOperators.POWER),
                    BiOperators.MULTIPLY);
            case SQUARE -> MathInput.func(MathInput.val(2), in, BiOperators.MULTIPLY);
            case TAN -> MathInput.func(MathInput.func(in, MonoOperators.SEC), MonoOperators.SQUARE);
            case TANH -> MathInput.func(MathInput.func(in, MonoOperators.SECH), MonoOperators.SQUARE);
        };
        return MathInput.func(oneDer, in.differentiate(), BiOperators.MULTIPLY);
    }

    @Override
    public String toString() {
        return op.toString().formatted(in);
    }
}
