package net.leng.math;

import java.util.function.DoubleFunction;
import java.util.function.IntFunction;

public class MoreMath {
    public static final double PI2 = Math.PI * Math.PI;

    /** Hyperbolic cosecant
     * */
    public static double csch(double num) {
        return (Math.exp(num) * 2) / (Math.exp(2 * num) - 1);
    }

    /** Hyperbolic cotangent
     * */
    public static double coth(double num) {
        return (Math.exp(2 * num) + 1) / (Math.exp(2 * num) - 1);
    }

    /** Hyperbolic secant
     * */
    public static double sech(double num) {
        return (Math.exp(num) * 2) / (Math.exp(2 * num) + 1);
    }

    /** Returns the trigonometric cosecant of an angle. Defined as csc(x)=hypotenuse/opposite side.
     *
     * @param   a   an angle, in radians.
     * @return  the cosecant of the argument.
     * */
    public static double csc(double a) {
        return 1 / Math.sin(a);
    }

    /** Returns the trigonometric cotangent of an angle. Defined as cot(x)=adjacent side/opposite side.
     *
     * @param   a   an angle, in radians.
     * @return  the cotangent of the argument.
     * */
    public static double cot(double a) {
        return Math.cos(a) / Math.sin(a);
    }

    /** Returns the trigonometric secant of an angle. Defined as csc(x)=hypotenuse/adjacent side.
     *
     * @param   a   an angle, in radians.
     * @return  the secant of the argument.
     * */
    public static double sec(double a) {
        return 1 / Math.cos(a);
    }

    /** Arcsecant*/
    public static double asec(double num) {
        return Math.acos(1 / num);
    }

    /** Arccosecant*/
    public static double acsc(double num) {
        return Math.asin(1 / num);
    }

    /** Arccotagent*/
    public static double acot(double num) {
        return Math.atan(-num) + Math.PI/2;
    }

    /***/
    public static double summation(int start, int end, IntFunction<Double> function) {
        if (end < start) return 0;
        double summed = 0;
        for (int i = start; i <= end; i++) {
            summed += function.apply(i);
        }
        return summed;
    }

    /***/
    public static double product(int start, int end, IntFunction<Double> function) {
        if (end < start) return 0;
        double prod = 1;
        for (int i = start; i <= end; i++) {
            prod *= function.apply(i);
        }
        return prod;
    }

    /** The derivative is used to find the instantaneous rate of change occurring at a certain point on the graph.
     * @param function The function that is being differentiated.
     * @param x The value inputted into the differential function "f'(x)"
     * @return The instantaneous rate of change at x*/
    public static double derivative(DoubleFunction<Double> function, double x) {
        double x1 = Math.nextUp((float)x);
        double y = limit(function, x);
        double y1 = limit(function, x1);
        return (float)((y1 - y) / (x1 - x));
    }

    /** The integral is used to find the area underneath the curve under two points on the graph.
     * @param function The function in which the area of the curve is being looked for.
     * @param start The lower bound of the integral.
     * @param end The upper bound of the integral.
     * @return The area underneath the curve of the function between x=start and x=end.*/
    public static double integral(DoubleFunction<Double> function, double start, double end) {
        if (Double.isNaN(start) || Double.isNaN(end)) return Double.NaN;
        if (end == start) return 0;
        float m = 0.5f;
        if (end < start) {
            double t = end;
            end = start;
            start = t;
            m *= -1f;
        }
        float mid = midpoint(Math.abs(start), Math.abs(end));
        if (Double.isInfinite(start)) start = -Float.MAX_VALUE;
        if (Double.isInfinite(end)) end = Float.MAX_VALUE;
        double i = start;
        double diff = Math.nextUp(mid) - mid;
        double j = start + diff;
        double sum = 0;
        while (i < end) {
            double y = limit(function, i);
            double y1 = limit(function, j);
            sum += (y + y1) * diff;
            i = j;
            j += diff;
        }
        return (float)(sum * m);
    }

    private static float midpoint(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) return Float.NaN;
        if (a == b) return (float)a;
        if (Double.isInfinite(a) && Double.isInfinite(b) && a != b) return Float.MAX_VALUE/2;
        if (Double.isInfinite(b)) return b < 0 ? -Float.MAX_VALUE/2 : Float.MAX_VALUE/2;
        if (Double.isInfinite(a)) return a < 0 ? -Float.MAX_VALUE/2 : Float.MAX_VALUE/2;
        return (float)(a/2 + b/2);
    }

    /** A limit is used to find where a value approaches as a number nears a certain point on a graph.
     * If the limit returns NaN, that indicates one of two possibilities.
     * <ul>
     *     <li>The point in that graph is beyond the domain of the function.</li>
     *     <li>The point in that graph lies on a vertical asymptote of the function.</li>
     * </ul>
     * The limit can return Infinity and Negative Infinity if both sides around the value the limit is being looked for
     * is approaching that direction and can certainly indicate the presence of a vertical asymptote at that point on the
     * graph.
     * @param function The function where the limit of which is being looked for.
     * @param c The point on the graph where the limit is being looked for.
     * @return The limit as x approaches c in the function.
     * */
    public static double limit(DoubleFunction<Double> function, double c) {
        if (c == Double.POSITIVE_INFINITY) return infiniteLimit(function, false);
        if (c == Double.NEGATIVE_INFINITY) return infiniteLimit(function, true);
        double r = function.apply(c);
        if (Double.isInfinite(r)) {
            double upper = Math.nextUp((float)r);
            double lower = Math.nextDown((float)r);
            double uAns = function.apply(upper);
            double lAns = function.apply(lower);
            if (uAns > 0 && lAns > 0) return Double.POSITIVE_INFINITY;
            if (uAns < 0 && lAns < 0) return Double.NEGATIVE_INFINITY;
            return Double.NaN;
        }
        if (Double.isNaN(c) || Double.isNaN(r)) {
            double c1 = Math.nextDown((float)c);
            double c2 = Math.nextUp((float)c);
            double r1 = function.apply(c1);
            double r2 = function.apply(c2);
            if (Double.isNaN(r1)) {
                double c3 = Math.nextUp((float)c2);
                double r3 = function.apply(c3);
                return r3 > r2 ? Math.nextDown(r2) : Math.nextUp(r2);
            }
            if (Double.isNaN(r2)) {
                double c3 = Math.nextDown((float)c1);
                double r3 = function.apply(c3);
                return r3 > r1 ? Math.nextUp(r1) : Math.nextDown(r1);
            }
            if (Double.isNaN(r2) && Double.isNaN(r1)) return Double.NaN;
            return r1/2 + r2/2;
        }
        return r;
    }

    /** A sided limit is used to find where a value approaches as a number nears a certain point on a graph from a certain
     * specified direction. If the limit returns NaN, that means the point in that graph is beyond the domain of the function
     * or cannot be approached from the specified direction.
     * If the sided limit returns infinity or negative infinity, this means that the function at that point has an asymptote.
     * @param function The function where the limit of which is being looked for.
     * @param c The point on the graph where the limit is being looked for.
     * @param neg Determines the direction the limit is being approached:
     *            true means from the left-hand side while false means from the right-hand side of the graph.
     * @return The limit as x approaches c in the function from one side.
     * */
    public static double sidedLimit(DoubleFunction<Double> function, double c, boolean neg) {
        if (c == Double.POSITIVE_INFINITY) return neg ? infiniteLimit(function, false) : Double.NaN;
        if (c == Double.NEGATIVE_INFINITY) return neg ? Double.NaN : infiniteLimit(function, true);
        double r = function.apply(c);
        if (Double.isNaN(r)) {
            if (neg) {
                double val = Math.nextDown((float)c);
                double ans = function.apply(val);
                while (Double.isNaN(ans)) {
                    val = Math.nextDown((float)val);
                    ans = function.apply(val);
                }
                return ans;
            } else {
                double val = Math.nextUp((float)c);
                double ans = function.apply(val);
                while (Double.isNaN(ans)) {
                    val = Math.nextUp((float)val);
                    ans = function.apply(val);
                }
                return ans;
            }
        }
        return r;
    }
    /** The infinite limit is a function that looks for the limit of a function as it approaches either positive or
     * negative infinity.
     * <br>
     * What the function returns has meanings on the graph in question.
     * <ul>
     *     <li>If the function returns infinity or negative infinity, it means the function lacks any horizontal asymptotes.</li>
     *     <li>If the function returns a non-infinite value, this indicates that the function has a horizontal asymptote.</li>
     *     <li>If the function returns NaN, this indicates that the direction of infinity is not part of the function's domain</li>
     * </ul>
     * @param function The function where the limit of which is being looked for.
     * @param neg The direction the limit is going towards: true means towards negative infinity and false means towards positive infinity.
     * @return The limit as x approaches infinity in the function.
     * */
    public static double infiniteLimit(DoubleFunction<Double> function, boolean neg) {
        double val = Double.MAX_VALUE;
        double mult = neg ? -1 : 1;
        double r = function.apply(mult * val);
        while (Double.isNaN(r)) {
            val = Math.nextDown((float)val);
            r = function.apply(mult * val);
        }
        return r;
    }

    /***/
    public static double erf(double z) {
        return 2 / Math.sqrt(Math.PI) * integral(t -> Math.exp(-(t * t)), 0, z);
    }
}
