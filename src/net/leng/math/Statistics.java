package net.leng.math;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class Statistics {
    public static double standardDeviation(double... vals) {
        return Math.sqrt(variance(vals));
    }

    public static double variance(double... vals) {
        double var = 0;
        double mean = mean(vals);
        for (double d : vals) {
            var += Math.pow(d - mean, 2);
        }
        return var;
    }

    public static double standardizedScore(int ind, double... vals) {
        if (ind < 0 || ind >= vals.length) throw new InvalidParameterException();
        double sd = standardDeviation(vals);
        double mean = mean(vals);
        return (vals[ind] - mean) / sd;
    }

    public static double mean(double... vals) {
        double sum = 0;
        for (double d : vals) {
            sum += d;
        }
        return sum / vals.length;
    }

    public static double trimmedMean(double percentage, double... vals) {
        Arrays.sort(vals);
        double sum = 0;
        int len = vals.length;
        int diff = (int)(percentage * len);
        for (int i = diff; i < len - diff; i++) {
            sum += vals[i];
        }
        return sum / (vals.length - (2 * diff));
    }

    public static double median(double... vals) {
        Arrays.sort(vals);
        int len = vals.length;
        if (len % 2 == 0) {
            return (vals[len/2 - 1] + vals[len/2]) / 2;
        }
        return vals[len/2];
    }

    public static double[] quartiles(double... vals) {
        Arrays.sort(vals);
        int len = vals.length;
        int hl = len/2;
        double median = len % 2 == 0 ? (vals[hl-1] + vals[hl]) / 2 : vals[hl];
        double q1 = hl % 2 == 0 ? (vals[len/4-1] + vals[len/4]) / 2 : vals[len/4];
        double q3 = hl % 2 == 0 ? (vals[3 * len/4 - 1] + vals[3 * len/4]) / 2 : vals[len/4];
        return new double[]{q1, median, q3};
    }

    public static double correlationCoefficient(double[] a, double[] b) {
        int alen = a.length;
        int blen = b.length;
        if (alen != blen) throw new IllegalArgumentException("List sizes must be the same");
        double sum = 0;
        double asd = standardDeviation(a);
        double bsd = standardDeviation(b);
        double amean = mean(a);
        double bmean = mean(b);
        for (int i = 0; i < alen; i++) {
            sum += ((a[i] - amean) / asd) * ((b[i] - bmean) / bsd);
        }
        return sum / (alen - 1);
    }
}
