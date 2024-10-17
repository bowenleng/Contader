package net.leng.math;

import net.leng.math.complexnums.ComplexMath;
import net.leng.math.complexnums.ComplexNumber;

import java.util.function.DoubleFunction;

public class SuppMath {
    public static final double PI2 = Math.PI * Math.PI;

    public static double csch(double num) {
        return (Math.exp(num) * 2) / (Math.exp(2 * num) - 1);
    }

    public static double coth(double num) {
        return (Math.exp(2 * num) + 1) / (Math.exp(2 * num) - 1);
    }

    public static double sech(double num) {
        return (Math.exp(num) * 2) / (Math.exp(2 * num) + 1);
    }

    public static int factorial(int num) {
        if (num < 0) throw new IllegalArgumentException("Cannot take a basic factorial of a negative number");
        if (num == 0) return 1;
        return (int)product(1, num, n -> n);
    }

    public static double summation(int start, int end, DoubleFunction<Double> function) {
        if (end < start) return 0;
        double summed = 0;
        for (int i = start; i <= end; i++) {
            summed += function.apply(i);
        }
        return summed;
    }

    public static double product(int start, int end, DoubleFunction<Double> function) {
        if (end < start) return 0;
        double prod = 1;
        for (int i = start; i <= end; i++) {
            prod *= function.apply(i);
        }
        return prod;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) throw new IllegalArgumentException("Cannot determine whether number is prime");
        if (num == 2 || num == 3) return true;
        if ((num & 1) == 0 || num % 3 == 0) return false;
        for (int i = 5; i <= num/2; i += ((i + 2) % 3 == 0 ? 4 : 2)) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isPerfect(int num) {
        if (num <= 0) throw new IllegalArgumentException("Cannot determine whether number is perfect");
        int sum = 1;
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    public static int nthPerfectSquare(int n) {
        int ps = 0;
        for (int i = 0; i < n; i++) {
            ps += 1 + (i * 2);
        }
        return ps;
    }
}
