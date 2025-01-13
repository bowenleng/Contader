package net.leng.math.directionalnum;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Function;

public class ComplexMath {
    private static final ComplexNumber ZERO = new ComplexNumber();

    private static final Random RANDOM = new Random();

    private ComplexMath() {} // ensures no one has access to the object

    /** @return  Value of sqrt(-1) */
    @Contract(value = " -> new", pure = true)
    public static @NotNull ComplexNumber i() {
        return new ComplexNumber(0, 1);
    }

    /** @return Value of i times {@link Math}.PI*/
    @Contract(value = " -> new", pure = true)
    public static @NotNull ComplexNumber iPi() {
        return new ComplexNumber(0, Math.PI);
    }

    /** @return Value of 0 stored in the form of a complex number. */
    @Contract(value = " -> new", pure = true)
    public static @NotNull ComplexNumber zero() {
        return new ComplexNumber();
    }

    /** @return  Value of negative infinity stored in the form of a complex number. */
    @Contract(value = " -> new", pure = true)
    public static @NotNull ComplexNumber negativeInfinity() {
        return new ComplexNumber(Double.NEGATIVE_INFINITY);
    }

    /** @return Value of positive infinity stored in the form of a complex number. */
    @Contract(value = " -> new", pure = true)
    public static @NotNull ComplexNumber positiveInfinity() {
        return new ComplexNumber(Double.POSITIVE_INFINITY);
    }

    /** @return Not a number stored as a complex number. Generally returned in place of {@link ArithmeticException}*/
    @Contract(value = " -> new", pure = true)
    public static @NotNull ComplexNumber nan() {
        return new ComplexNumber(Double.NaN);
    }

    /** Calculates distance of the complex number on the complex plane from 0.
     * @param pNum the complex number value.
     * @return Magnitude of distance from zero to the inputted number.
     * */
    public static double abs(ComplexNumber pNum) {
        if (pNum == null || pNum.equals(ZERO)) return 0;
        return Math.sqrt(Math.pow(pNum.getReal(), 2) + Math.pow(pNum.getImaginary(), 2));
    }

    /** Finds the angle of the line that contains the complex number relative to the positive real number axis.
     * @param pNum the complex number value.
     * @return the angle in radians of the line that contains the complex number relative to the positive real number axis.
     * */
    public static double arg(ComplexNumber pNum) {
        if (pNum == null) return Math.atan2(0, 0);
        return Math.atan2(pNum.getImaginary(), pNum.getReal());
    }

    /** Takes e to the power of a complex number.
     * In accordance to Euler's identity, e^(xi * <i>pi</i>) = cos(x) + <i>i</i>sin(x) which is equal to <i>i</i>^(2x),
     * any imaginary value inputted into this function will yield a number
     * that is on the unit circle of the complex number plane.
     * If the input is null or equals 0, the function returns 1,
     * the function returns 1;
     * @param pNum the complex number value.
     * @return e to the power of a complex number.
     * */
    @Contract("null -> new")
    public static @NotNull ComplexNumber exp(ComplexNumber pNum) {
        if (pNum == null || pNum.equals(ZERO)) return new ComplexNumber(1);
        double multiplier = Math.exp(pNum.getReal());
        double arg = (pNum.getImaginary() / 2) * Math.log(Math.exp(2));
        double real = multiplier * Math.cos(arg);
        double imaginary = multiplier * Math.sin(arg);
        return new ComplexNumber(real, imaginary);
    }

    /** Takes the natural log of a complex number.
     * In accordance to Euler's identity, e^(x<i>i</i> * <i>pi</i>) = cos(x) + <i>i</i>sin(x) which is equal to <i>i</i>^(2x),
     * any value inputted with an absolute value of approximately 1 will yield a purely imaginary number.
     * If the input is null or equals 0, it will return negative infinity.
     * @param pNum the complex number value.
     * @return a number that if e is taken to the power of, will return the inputted complex number.
     * */
    public static @NotNull ComplexNumber log(ComplexNumber pNum) {
        if (pNum == null || pNum.equals(ZERO)) return negativeInfinity();
        double real = Math.log(abs(pNum));
        double imaginary = arg(pNum);
        return new ComplexNumber(real, imaginary);
    }

    /** Takes the log base 10 of a complex number, ie 10 to the power of the output equals the input.
     * If the input is null or equals zero, it will return negative infinity.
     * @param pNum the complex number value.
     * @return a number that if 10 is taken to the power of, will return the inputted complex number.
     * */
    public static @NotNull ComplexNumber log10(ComplexNumber pNum) {
        if (pNum == null || pNum.equals(ZERO)) return negativeInfinity();
        double real = Math.log10(abs(pNum));
        double imaginary = arg(pNum) / Math.log(10);
        return new ComplexNumber(real, imaginary);
    }

    /** @return the complex number with the greatest absolute value between a and b. */
    @Contract("null, !null -> param2; !null, null -> param1")
    public static @NotNull ComplexNumber max(ComplexNumber a, ComplexNumber b) {
        if (a == null) {
            return b == null ? zero() : b;
        }
        if (b == null) return a;
        return a.isGreaterThan(b) ? a : b;
    }

    /** @return the complex number with the smallest absolute value between a and b. */
    public static @NotNull ComplexNumber min(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null) return zero();
        return a.isSmallerThan(b) ? a : b;
    }

    /** @return a complex number with a random value between 0 and 1 inclusive-exclusive on both the real and imaginary components.*/
    @Contract(" -> new")
    public static @NotNull ComplexNumber random() {
        return new ComplexNumber(RANDOM.nextDouble(), RANDOM.nextDouble());
    }

    /** Takes a real number to the power of a complex number.
     * If the inputted complex number is 0 or null, then the function returns 1 as any number to the 0th power equals 1.
     * @param pBase a real number being taken to the power of.
     * @param pExp a complex exponent.
     * @return A real number to the power of a complex number. */
    @Contract("_, null -> new")
    public static @NotNull ComplexNumber pow(double pBase, ComplexNumber pExp) {
        if (pExp == null || pExp.equals(ZERO)) {
            return new ComplexNumber(1);
        }
        double multiplier = Math.pow(pBase, pExp.getReal());
        double arg = (pExp.getImaginary() / 2) * Math.log(Math.pow(pBase, 2));
        double real = multiplier * Math.cos(arg);
        double imaginary = multiplier * Math.sin(arg);
        return new ComplexNumber(real, imaginary);
    }

    /** Takes a complex number to the power of a real number.
     * If the inputted complex number is 0 or is null,
     * if the exponent is smaller than 0, the function returns positive infinity, otherwise it returns 0.
     * @param pBase complex number base.
     * @param pExp real exponent.
     * @return A complex number to the power of a real number.
     * */
    public static @NotNull ComplexNumber pow(ComplexNumber pBase, double pExp) {
        if (pBase == null || pBase.equals(ZERO)) {
            return pExp < 0 ? positiveInfinity() : new ComplexNumber();
        }
        double r = abs(pBase);
        double theta = arg(pBase);
        double real = Math.pow(r, pExp) * Math.cos(pExp * theta);
        double imaginary = Math.pow(r, pExp) * Math.sin(pExp * theta);
        return new ComplexNumber(real, imaginary);
    }

    /** Takes a complex number to the power of a complex number.
     * <ul>
     * <li>If the exponent is null or is 0, then the function returns 1.</li>
     * <li>If the base is null or equals 0:</li>
     * <ul>
     *     <li>if the exponent's imaginary value is none
     *     <ul>
     *         <li>If the exponent is smaller than zero, the function returns positive infinity</li>
     *         <li>Otherwise the function returns 0.</li>
     *     </ul>
     *     </li>
     *     <li>If the exponent has an imaginary component, the function returns NaN</li>
     * </ul>
     * </ul>
     * @param pBase complex number base.
     * @param pExp complex number exponent.
     * @return a complex number base to the power of another complex number.
     * */
    public static ComplexNumber pow(ComplexNumber pBase, ComplexNumber pExp) {
        if (pExp == null || pExp.equals(ZERO)) {
            return new ComplexNumber(1);
        }
        if (pBase == null || pBase.equals(ZERO)) {
            if (pExp.getImaginary() != 0) return nan();
            return pExp.getReal() < 0 ? positiveInfinity() : new ComplexNumber();
        }
        double multiplier = Math.pow(abs(pBase), pExp.getReal()) * Math.pow(Math.E, -pExp.getImaginary() * arg(pBase));
        double argR = pExp.getReal() * arg(pBase);
        double argI = (pExp.getImaginary() / 2) * Math.log(Math.pow(pBase.getReal(), 2) + Math.pow(pBase.getImaginary(), 2));
        double real = multiplier * Math.cos(argR + argI);
        double imaginary = multiplier * Math.sin(argR + argI);
        return new ComplexNumber(real, imaginary);
    }

    /** Takes the cube root of a complex number.
     * @param pNum complex number taken to the cube root.
     * @return A complex number equal to the cube root of the inputted complex number.
     * */
    @Contract("null -> new")
    public static @NotNull ComplexNumber cbrt(ComplexNumber pNum) {
        if (pNum == null) return new ComplexNumber();
        double r = abs(pNum);
        double theta = arg(pNum);
        double real = Math.cbrt(r) * Math.cos(theta / 3);
        double imaginary = Math.cbrt(r) * Math.sin(theta / 3);
        return new ComplexNumber(real, imaginary);
    }

    /** Takes the square root of a real number.
     * Since this function returns a complex number itself,
     * taking the square root of negatives numbers are permitted and will return imaginary numbers as a result.
     * @param pNum real number inputted.
     * @return the square root of a real number.
     * */
    public static @NotNull ComplexNumber sqrt(double pNum) {
        return pNum >= 0 ? new ComplexNumber(Math.sqrt(pNum)) : new ComplexNumber(0, Math.sqrt(-pNum));
    }

    /** Takes the square root of a complex number.
     * Since this function returns a complex number itself,
     * taking the square root of negatives numbers are permitted and will return imaginary numbers as a result.
     * @param pNum complex number inputted.
     * @return the square root of a complex number.
     * */
    @Contract("null -> new")
    public static @NotNull ComplexNumber sqrt(ComplexNumber pNum) {
        if (pNum == null) return new ComplexNumber();
        double r = abs(pNum);
        double theta = arg(pNum);
        double real = Math.sqrt(r) * Math.cos(theta / 2);
        double imaginary = Math.sqrt(r) * Math.sin(theta / 2);
        return new ComplexNumber(real, imaginary);
    }

    public static double angle(ComplexNumber pNum) {
        return Math.atan(pNum.getImaginary() / pNum.getReal());
    }

    public static @NotNull ComplexNumber complexSummation(int start, int end, Function<Double, Double> function) {
        if (end < start) return ComplexNumber.of();
        ComplexNumber summed = ComplexNumber.of();
        for (int i = start; i <= end; i++) {
            summed.addAssign(function.apply((double)i));
        }
        return summed;
    }

    public static @NotNull ComplexNumber complexProduct(int start, int end, Function<Double, Double> function) {
        if (end < start) return ComplexNumber.of();
        ComplexNumber prod = ComplexNumber.of();
        for (int i = start; i <= end; i++) {
            prod.multiplyAssign(function.apply((double)i));
        }
        return prod;
    }

    public static ComplexNumber complexDerivative(Function<ComplexNumber, ComplexNumber> function, ComplexNumber z) {
        double direction = angle(z);
        double x = abs(z);
        double v = Math.nextUp(x);
        ComplexNumber z1 = ComplexNumber.fromMagnitude(v, direction);
        ComplexNumber y = function.apply(z);
        ComplexNumber y1 = function.apply(z1);
        return (y1.subtract(y)).divide(z1.subtract(z));
    }
}
