package net.leng.math;

import java.util.function.DoubleFunction;

public class SuppMath {
    public static final double PI2 = Math.PI * Math.PI;
    private static final double[] FACTORIALS = new double[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880,
            2628800, 39916800, 479001600, 6.2270208E+9, 8.71782912E+10, 1.307674368E+12, 2.0922789888E+13,
            3.55687428096E+14, 6.402373705728E+15, 1.216451004088E+17, 2.432902008177E+18, 5.109094217170944E+19,
            1.12400072777760768E+21, 2.58520167388849766E+22, 6.20448401733239439E+23, 1.5511210043330986E+25,
            4.03291461126605636E+26, 1.08888694504183522E+28, 3.04888344611713861E+29, 8.84176199373970195E+30,
            2.65252859812191059E+32};

    public static double intExp(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            if (exponent < 0) {
                result /= base;
            } else {
                result *= base;
            }
        }
        return result;
    }

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
