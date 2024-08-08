package net.leng.math;

import java.util.function.DoubleFunction;

public class SuppMath {
    public static final double PI2 = Math.PI * Math.PI;

    public static double csc(double angle) {
        angle %= 2 * Math.PI;
        return  0;
    }

    public static double summation(int start, int end, DoubleFunction<Double> function) {
        if (end < start) return 0;
        double summed = 0;
        for (int i = start; i < end; i++) {
            summed += function.apply(i);
        }
        return summed;
    }

    public static double product(int start, int end, DoubleFunction<Double> function) {
        if (end < start) return 0;
        double summed = 0;
        for (int i = start; i < end; i++) {
            summed *= function.apply(i);
        }
        return summed;
    }

    private static double cscApprox(double angle) {
        return ((5 * PI2) - (4 * Math.PI) * (Math.PI - angle)) / (16 * Math.PI * (Math.PI - angle));
    }
}
