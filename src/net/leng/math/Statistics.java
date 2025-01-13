package net.leng.math;

import net.leng.array.ArrayMaker;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Statistics {

    /**
     * Stdev(s for samples, σ for populations) is a measure of spread that generally
     * provides a measure of how far a data point would be from the mean relative to other data points on the data set.
     * <p>
     * It is a non-robust measure of variability meaning outliers in the dataset can significantly shift the value
     * of the standard deviation.
     *
     * @param vals A list of data points inputted into the function.
     * @return The standard deviation of the data points in vals.
     * */
    public static double stdev(double... vals) {
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
     * The z-Score (also known as standardized score) is a measure of how far any given data point
     * is located from the mean relative to all other data points in the dataset.
     * <p>
     * Z-Scores do not have a unit of measurement but the difference between two
     * consecutive integers is equivalent to the standard deviation of the dataset.
     * @param data The value with its z-score measured.
     * @param vals The data points ind is being compared against.
     * @return The z-score of data in comparison to vals.
     * */
    public static double zScore(int data, double... vals) {
        if (data < 0 || data >= vals.length) throw new IllegalArgumentException();
        double sd = stdev(vals);
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
        double[] d = ArrayMaker.makeSortedArray(vals);
        double sum = 0;
        int len = d.length;
        int diff = (int)(percentage * len);
        for (int i = diff; i < len - diff; i++) {
            sum += d[i];
        }
        return sum / (len - (diff << 1));
    }

    public static double median(double... vals) {
        double[] d = ArrayMaker.makeSortedArray(vals);
        int len = d.length;
        int hl = len >> 1;
        if ((len & 1) == 0) {
            return (d[hl - 1] + d[hl]) / 2;
        }
        return d[hl];
    }

    @Contract("_ -> new")
    public static double @NotNull [] quartiles(double... vals) {
        double[] d = ArrayMaker.makeSortedArray(vals);
        int len = d.length;
        int hl = len >> 1;
        int ql = hl >> 1;
        double median = (len & 1) == 0 ? (d[hl-1] + d[hl]) / 2 : d[hl];
        double q1 = (hl & 1) == 0 ? (d[ql-1] + d[ql]) / 2 : d[ql];
        double q3 = (hl & 1) == 0 ? (d[3 * ql - 1] + d[3 * ql]) / 2 : d[3 * ql];
        return new double[]{q1, median, q3};
    }

    @Contract(pure = true)
    public static double smallest(double @NotNull ... vals) {
        double smallest = Double.MAX_VALUE;
        for (double d : vals) {
            if (d < smallest) smallest = d;
        }
        return smallest;
    }

    @Contract(pure = true)
    public static double largest(double @NotNull ... vals) {
        double largest = -Double.MAX_VALUE;
        for (double d : vals) {
            if (d > largest) largest = d;
        }
        return largest;
    }

    @Contract(pure = true)
    public static double range(double @NotNull ... vals) {
        double smallest = Double.MAX_VALUE;
        double largest = -Double.MAX_VALUE;
        for (double d : vals) {
            if (d > largest) largest = d;
            if (d < smallest) smallest = d;
        }
        return largest - smallest;
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
    public static double correlationCoefficient(double @NotNull [] a, double @NotNull [] b) {
        int alen = a.length;
        int blen = b.length;
        if (alen != blen) throw new IllegalArgumentException("List sizes must be the same");
        double sum = 0;
        double asd = stdev(a);
        double bsd = stdev(b);
        double amean = mean(a);
        double bmean = mean(b);
        for (int i = 0; i < alen; i++) {
            sum += ((a[i] - amean) / asd) * ((b[i] - bmean) / bsd);
        }
        return sum / (alen - 1);
    }

    /** A factorial is a probability function in statistics that determines how many possible permutations there are
     * assuming that the number of slots is equal to the number of items there are.
     * @param num The number inputted into the function.
     * @return The number of possibilities.
     * */
    public static int factorial(int num) {
        if (num < 0) throw new IllegalArgumentException("Cannot take a basic factorial of a negative number");
        if (num == 0) return 1;
        return (int)MoreMath.product(1, num, n -> (double)n);
    }


    /** A combination in statistics is how many ways elements in a set
     * can organize themselves if "r" slots are available regardless of order.
     * @param r The number of slots available a dataset.
     * @param n The total count of how many elements are in a dataset.
     * @return The amount of ways data can organize themselves regardless of order.
     * */
    public static int combinationCount(int r, int n) {
        return permutationCount(r, n) / factorial(r);
    }

    /** A permutation in statistics is how many ways elements in a set
     * can organize themselves if "r" slots are available in which order is relevant.
     * @param r The number of slots available a dataset.
     * @param n The total count of how many elements are in a dataset.
     * @return The amount of ways data can organize themselves.
     * */
    public static int permutationCount(int r, int n) {
        return (int) MoreMath.product(n - r + 1, n, v -> (double)v);
    }

    /** A function defined that looks for the probability of a desired outcome occurring out of all
     * possible outcomes.
     * @param r Number of desired outcomes
     * @param n Number of total outcomes.
     * @return Probability of something occurring represented as a number between 0 and 1.
     * */
    public static double probability(int r, int n) {
        return (double)r / n;
    }

    /** The binomial pdf or the probability density function for binomial probability distributions (Bernoulli trial distributions)
     * is used to find the probability of the number of trials has the desired outcomes from the total number
     * of trials.
     * @param n The total number of trials.
     * @param p The probability of a desired outcome occurring in one trial.
     * @param x The number of trials with the desired outcome.
     * @return Probability of a set number of trials with a desired outcome as represented as a number between 0 and 1.
     * */
    public static double binomialPdf(int n, double p, int x) {
        return combinationCount(x, n) * Math.pow(p, x) * Math.pow(1 - p, n - x);
    }

    /** The binomial cdf or the cumulative density function for binomial probability distributions (Bernoulli trial distributions)
     * is used to find the probability of having a certain number of trials that has a desired outcomes or less out of a total
     * number of trials.
     * @param n The total number of trials.
     * @param p The probability of a desired outcome occurring in one trial.
     * @param x The number of trials with the desired outcome.
     * @return Probability of a set number of trials or below with a desired outcome occuring as represented as a number between 0 and 1.
     * */
    public static double binomialCdf(final int n, final double p, int x) {
        return MoreMath.summation(0, x, v -> binomialPdf(n, p, v));
    }

    /***/
    public static double binomialMean(int n, double p) {
        return n * p;
    }

    /***/
    public static double binomialStdev(int n, double p) {
        return Math.sqrt(n * p * (1 - p));
    }

    /** The geometric pdf or probability density function for geometric distributions is used to find the number
     * of desired outcomes based on the probability of a desired outcome occurring in one trial and the number of times
     * the desired outcome occurs.
     * @param p Probability of a desired outcome in a trial
     * @param x The number of trials a desired outcome has occurred.
     * @return Probability of that number of trials with a desired outcome as represented as a number between 0 and 1.
     * */
    public static double geometricPdf(double p, int x) {
        return p * Math.pow(1 - p, x - 1);
    }

    /** The geometric cdf or cumulative density function for geometric distributions is used to find the probability
     * of a desired outcome occurring if it has occurred a certain number of times or less.
     * @param p Probability of a desired outcome in a trial
     * @param x The maximum amount of trials that can happen.
     * @return Probability of that a number of trials with a desired outcome occurring or less as represented as a number between 0 and 1.
     * */
    public static double geometricCdf(double p, int x) {
        return 1 - Math.pow(1 - p, x);
    }

    /***/
    public static double geometricMean(double p) {
        return 1d / p;
    }

    /***/
    public static double geometricStdev(double p) {
        return Math.sqrt((1 - p) / Math.pow(p, 2));
    }

    /** The normal cdf or cumulative density function for normal distributions is used to find the probability of a desired
     * outcome occurring under a set of continuous datasets.
     * @param mean The mean of the data set.
     * @param stdev The standard deviation of the data set.
     * @param start The lower bound of the distribution in which the probability of which the function is looking for.
     * @param end The upper bound of the distribution in which the probability of which the function is looking for.
     * @return The probability of an outcome between the end and start of a function occurring.*/
    public static double normalCdf(final double mean, final double stdev, double start, double end) {
        return (1/(stdev * Math.sqrt(2 * Math.PI)))
                * MoreMath.integral(x -> Math.exp(-Math.pow((x-mean)/stdev, 2) / 2), start, end);
    }
}
