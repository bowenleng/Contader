package net.leng.math;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class Statistics {

    /**
     * Standard Deviation(s for samples, σ for populations) is a measure of spread that generally
     * provides a measure of how far a data point would be from the mean relative to other data points on the data set.
     * <p>
     * It is a non-robust measure of variability meaning outliers in the dataset can significantly shift the value
     * of the standard deviation.
     *
     * @param vals A list of data points inputted into the function.
     * @return The standard deviation of the data points in vals.
     * */
    public static double standardDeviation(double... vals) {
        return Math.sqrt(variance(vals));
    }

    /** Variance is a measure of spread that shows how spread out data points are.
     * <p>
     * In order to calculate variance, you first take the mean of the dataset.
     * With the mean, you then take the difference between a data point and the
     * dataset's mean for every data point in the data set and
     * add the squares of all the differences together to get the variance.
     * @param vals A list of data points inputted into the function.
     * @return the variance of all the data points in vals, or the standard deviation squared.
     * */
    public static double variance(double... vals) {
        double var = 0;
        double mean = mean(vals);
        for (double d : vals) {
            var += Math.pow(d - mean, 2);
        }
        return var;
    }

    /**
     * Standardized Score (also known as the z-score) is a measure of how far any given data point
     * is located from the mean relative to all other data points in the dataset.
     * <p>
     * Standardized Scores do not have a unit of measurement but the difference between two
     * consecutive integers is equivalent to the standard deviation of the dataset.
     * @param data The value with its z-score measured.
     * @param vals The data points ind is being compared against.
     * @return The z-score of data in comparison to vals.
     * */
    public static double standardizedScore(int data, double... vals) {
        if (data < 0 || data >= vals.length) throw new InvalidParameterException();
        double sd = standardDeviation(vals);
        double mean = mean(vals);
        return (vals[data] - mean) / sd;
    }

    /**
     * The mean is a measure of central tendency that shows the average between all numbers in a dataset.
     * <p>
     * The means is a non-robust measure meaning that it tends to change as a result of outliers.
     * <p>
     * Mean is calculated by adding all the numbers together and then
     * dividing the summed numbers by the total amount of elements in a dataset.
     * @param vals A list of data points inputted into the function.
     * @return The mean of all data points inside vals.
     * */
    public static double mean(double... vals) {
        double sum = 0;
        for (double d : vals) {
            sum += d;
        }
        return sum / vals.length;
    }

    /**
     * The trimmed mean is a measure of central tendency that shows the average between all numbers in a dataset
     * in which the outliers are to some degree, excluded from the calculation.
     * <p>
     * Trimmed mean is calculated by adding all the numbers together and then
     * dividing the summed numbers by the total amount of elements in a dataset where the.
     * @param vals A list of data points inputted into the function.
     * @return The mean of all data points inside vals.
     * */
    public static double trimmedMean(double percentage, double... vals) {
        Arrays.sort(vals);
        double sum = 0;
        int len = vals.length;
        int diff = (int)(percentage * len);
        for (int i = diff; i < len - diff; i++) {
            sum += vals[i];
        }
        return sum / (vals.length - (diff << 1));
    }

    public static double median(double... vals) {
        Arrays.sort(vals);
        int len = vals.length;
        int hl = len >> 1;
        if ((len & 1) == 0) {
            return (vals[hl - 1] + vals[hl]) / 2;
        }
        return vals[hl];
    }

    public static double[] quartiles(double... vals) {
        Arrays.sort(vals);
        int len = vals.length;
        int hl = len >> 1;
        int ql = hl >> 1;
        double median = len % 2 == 0 ? (vals[hl-1] + vals[hl]) / 2 : vals[hl];
        double q1 = (hl & 1) == 0 ? (vals[ql-1] + vals[ql]) / 2 : vals[ql];
        double q3 = (hl & 1) == 0 ? (vals[3 * ql - 1] + vals[3 * ql]) / 2 : vals[ql];
        return new double[]{q1, median, q3};
    }

    /**
     * Correlation Coefficient (often r) is a number that ranges between -1 and 1 that shows
     * how closely related two separate datasets are.
     * <ul>
     *     <li>If |r| is closer to 1, the two datasets are more closely related.</li>
     *     <li>If |r| is closer to 0, the two datasets are not so closely related.</li>
     * </ul>
     *
     * @param a the dataset that has the "explanatory" variables.
     * @param b the dataset that has the "response" variables.
     * @return the correlation coefficient (r) between datasets a and b.
     * */
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

    /** A combination in statistics is how many ways elements in a set
     * can organize themselves if "r" slots are available regardless of order.
     * @param r The number of slots available a dataset.
     * @param n The total count of how many elements are in a dataset.
     * @return The amount of ways data can organize themselves regardless of order.
     * */
    public static int combinationCount(int r, int n) {
        return SuppMath.factorial(n) /
                (SuppMath.factorial(r) * SuppMath.factorial(n - r));
    }

    /** A permutation in statistics is how many ways elements in a set
     * can organize themselves if "r" slots are available in which order is relevant.
     * @param r The number of slots available a dataset.
     * @param n The total count of how many elements are in a dataset.
     * @return The amount of ways data can organize themselves..
     * */
    public static int permutationCount(int r, int n) {
        return SuppMath.factorial(n) /
                SuppMath.factorial(n - r);
    }
}
