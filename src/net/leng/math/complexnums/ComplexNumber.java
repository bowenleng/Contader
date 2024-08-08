package net.leng.math.complexnums;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @Author NukolLodda
 * */
public class ComplexNumber implements Comparable<ComplexNumber> {
    private double real;

    private double imaginary;

    /** Defines a new complex number using a real and an imaginary component.
     * @param pReal The real component of the complex number.
     * @param pImaginary the imaginary component of the complex number.
     * */
    public ComplexNumber(double pReal, double pImaginary) {
        this.real = pReal;
        this.imaginary = pImaginary;
    }

    /** Defines a new real number with complex number behavior.
     * @param pReal The number to be defined anew as a complex number.
     * */
    public ComplexNumber(double pReal) {
        this(pReal, 0);
    }

    /** Defines a new complex number by duplicating another one.
     * @param pNum A complex number to be duplicated.
     * */
    public ComplexNumber(ComplexNumber pNum) {
        this(pNum != null ? pNum.getReal() : 0, pNum != null ? pNum.getImaginary() : 0);
    }

    /** Defines a new complex number with a value of 0. */
    public ComplexNumber() {
        this(0, 0);
    }

    /**@return the real component of this complex number. */
    public double getReal() {
        return real;
    }

    /**@return the imaginary component of this complex number. */
    public double getImaginary() {
        return imaginary;
    }

    /** Adds a real number to this complex number without redefining it.
     * @param pReal the real number that will be added.
     * @return new complex number that is an addition of the real number and this number.
     * */
    public ComplexNumber add(double pReal) {
        return new ComplexNumber(this.real + pReal, this.imaginary);
    }

    /** Adds a real and an imaginary number to this complex number without redefining it.
     * @param pReal the real number that will be added.
     * @param pImaginary the imaginary number that will be added.
     * @return new complex number that is an addition of the real and imaginary numbers and this number.
     * */
    public ComplexNumber add(double pReal, double pImaginary) {
        return new ComplexNumber(this.real + pReal, this.imaginary + pImaginary);
    }

    /** Adds a complex number to this number without redefining it.
     * @param pNum the complex number to be added on, if it is null, then the number is presumed to equal 0.
     * @return new complex number that is an addition of this and the existing complex number.
     * */
    public ComplexNumber add(ComplexNumber pNum) {
        return pNum != null ? add(pNum.real, pNum.imaginary) : add(0);
    }

    /** Adds a real number to this complex number while redefining the existing value.
     * @param pReal the real number that will be added.
     * @return the existing complex number with the real number added on to it.
     * */
    public ComplexNumber addAssign(double pReal) {
        this.real += pReal;
        return this;
    }

    /** Adds a real and an imaginary number to this complex number while redefining the existing value.
     * @param pReal the real number that will be added.
     * @param pImaginary the imaginary number that will be added.
     * @return the existing complex number with the real and imaginary numbers added on to it.
     * */
    public ComplexNumber addAssign(double pReal, double pImaginary) {
        this.real += pReal;
        this.imaginary += pImaginary;
        return this;
    }

    /** Adds a complex number to this number while redefining it.
     * @param pNum the complex number to be added on, if it is null, then the number is presumed to equal 0.
     * @return the existing complex number with the new complex number added on to it.
     * */
    public ComplexNumber addAssign(ComplexNumber pNum) {
        return pNum != null ? addAssign(pNum) : this;
    }

    /** Increments a number by one in the complex plane by adding sqrt(2)/2 + isqrt(2)/2 to the existing number.
     * @return the existing complex number incremented in the positive-positive diagonal of the complex plane.
     * */
    public ComplexNumber increment() {
        this.real += Math.sqrt(2) / 2;
        this.imaginary += Math.sqrt(2) / 2;
        return this;
    }

    /** Subtracts a real number to this complex number without redefining it.
     * @param pReal the real number that will be taken.
     * @return new complex number that is a removal of the real number from the existing number.
     * */
    public ComplexNumber subtract(double pReal) {
        return new ComplexNumber(this.real - pReal, this.imaginary);
    }

    /** Subtracts a real and an imaginary number to this complex number without redefining it.
     * @param pReal the real number that will be taken.
     * @param pImaginary the imaginary number that will be taken.
     * @return new complex number that is a removal of the real and imaginary numbers from the existing number.
     * */
    public ComplexNumber subtract(double pReal, double pImaginary) {
        return new ComplexNumber(this.real - pReal, this.imaginary - pImaginary);
    }

    /** Subtracts a complex number to this number without redefining it.
     * @param pNum the complex number to be taken out, if it is null, then the number is presumed to equal 0.
     * @return new complex number that is a removal of the complex number from the existing number.
     * */
    public ComplexNumber subtract(ComplexNumber pNum) {
        return pNum != null ? subtract(pNum.real, pNum.imaginary) : subtract(0);
    }

    /** Subtracts a real number to this complex number while redefining the existing value.
     * @param pReal the real number that will be taken out.
     * @return the existing complex number with the real number taken from it.
     * */
    public ComplexNumber subtractAssign(double pReal) {
        this.real -= pReal;
        return this;
    }

    /** Subtracts a real and an imaginary number to this complex number while redefining the existing value.
     * @param pReal the real number that will be taken out.
     * @param pImaginary the imaginary number that will be taken out.
     * @return the existing complex number with the real and imaginary numbers taken out of it.
     * */
    public ComplexNumber subtractAssign(double pReal, double pImaginary) {
        this.real -= pReal;
        this.imaginary -= pImaginary;
        return this;
    }

    /** Subtracts a complex number to this number while redefining it.
     * @param pNum the complex number to be taken out, if it is null, then the number is presumed to equal 0.
     * @return the existing complex number with the new complex number taken out of it.
     * */
    public ComplexNumber subtractAssign(ComplexNumber pNum) {
        return pNum != null ? subtractAssign(pNum.real, pNum.imaginary) : this;
    }

    /** Decrements a number by one in the complex plane by subtracting sqrt(2)/2 + isqrt(2)/2 out of the existing number.
     * @return the existing complex number moved in the negative-negative diagonal of the complex plane.
     * */
    public ComplexNumber decrement() {
        this.real -= Math.sqrt(2) / 2;
        this.imaginary -= Math.sqrt(2) / 2;
        return this;
    }

    /** Multiplies a real number to this complex number without redefining it.
     * @param pReal the real number that will be multiplied to this value.
     * @return new complex number that is a multiplication between the real number and the existing complex number.
     * */
    public ComplexNumber multiply(double pReal) {
        return new ComplexNumber(this.real * pReal, this.imaginary * pReal);
    }

    /** Multiplies the addition between a real and imaginary number to this complex number without redefining it.
     * @param pReal the real number added to the complex multiplier.
     * @param pImaginary the imaginary number added to the complex multiplier.
     * @return new complex number that is a multiplication of the complex multiplier and the existing complex number.
     * */
    public ComplexNumber multiply(double pReal, double pImaginary) {
        double real = (this.real * pReal) - (this.imaginary * pImaginary);
        double imaginary = (this.real * pImaginary) + (this.imaginary * pReal);
        return new ComplexNumber(real, imaginary);
    }

    /** Multiplies a complex number to this number without redefining it.
     * @param pNum the complex number to be multiplied to the existing value, if it is null, then the number is presumed to equal 0.
     * @return new complex number that is a multiplication of the complex number from the existing number.
     * */
    public ComplexNumber multiply(ComplexNumber pNum) {
        return pNum != null ? multiply(pNum.real, pNum.imaginary) : new ComplexNumber();
    }

    /** Multiplies a real number to this complex number while redefining the existing value.
     * @param pReal the real number to be multiplied.
     * @return the existing complex number with the real number multiplied to it.
     * */
    public ComplexNumber multiplyAssign(double pReal) {
        this.real *= pReal;
        this.imaginary *= pReal;
        return this;
    }

    /** Multiplies the addition between a real and imaginary number to this complex number while redefining it.
     * @param pReal the real number added to the complex multiplier.
     * @param pImaginary the imaginary number added to the complex multiplier.
     * @return the existing complex number multiplied by the complex multiplier.
     * */
    public ComplexNumber multiplyAssign(double pReal, double pImaginary) {
        this.real = (this.real * pReal) - (this.imaginary * pImaginary);
        this.imaginary = (this.real * pImaginary) + (this.imaginary * pReal);
        return this;
    }

    /** Multiplies a complex number to this number while redefining it.
     * @param pNum the complex number to be multiplied to the existing value, if it is null, then the number is presumed to equal 0.
     * @return existing complex number that is multiplied by the complex number.
     * */
    public ComplexNumber multiplyAssign(ComplexNumber pNum) {
        return pNum != null ? multiplyAssign(pNum.real, pNum.imaginary) : this;
    }

    /** Divided by a real number to this complex number without redefining it.
     * @param pReal the real number that will be the divisor.
     * @return new complex number that is the existing complex number divided by the real number.
     * */
    public ComplexNumber divide(double pReal) {
        return new ComplexNumber(this.real / pReal, this.imaginary / pReal);
    }

    /** Divides this complex number by the addition between a real and imaginary number without redefining it.
     * @param pReal the real number added to the complex divisor.
     * @param pImaginary the imaginary number added to the complex divisor.
     * @return new complex number that is the existing complex number divided by the complex divisor.
     * */
    public ComplexNumber divide(double pReal, double pImaginary) {
        double denom = Math.pow(pReal, 2) + Math.pow(pImaginary, 2);
        double real = ((pReal * this.real) + (pImaginary * this.imaginary)) / denom;
        double imaginary = ((pImaginary * this.real) + (pReal * this.imaginary)) / denom;
        return new ComplexNumber(real, imaginary);
    }

    /** Multiplies a complex number to this number without redefining it.
     * @param pNum the complex number to be multiplied to the existing value, if it is null, then the number is presumed to equal 0.
     * @return new complex number that is a multiplication of the complex number from the existing number.
     * */
    public ComplexNumber divide(ComplexNumber pNum) {
        return pNum != null ? divide(pNum.getReal(), pNum.getImaginary()) : divide(1);
    }

    /** Divides the existing complex number by a real number.
     * @param pReal the real number to be the divisor.
     * @return the existing complex number divided by the real number.
     * */
    public ComplexNumber divideAssign(double pReal) {
        this.real /= pReal;
        this.imaginary /= pReal;
        return this;
    }

    /** Divides the complex number by the addition between a real and imaginary number while redefining it.
     * @param pReal the real number added to the complex divisor.
     * @param pImaginary the imaginary number added to the complex divisor.
     * @return the existing complex number divided by the complex divisor.
     * */
    public ComplexNumber divideAssign(double pReal, double pImaginary) {
        double denom = Math.pow(pReal, 2) + Math.pow(pImaginary, 2);
        this.real = ((pReal * this.real) + (pImaginary * this.imaginary)) / denom;
        this.imaginary = ((pImaginary * this.real) + (pReal * this.imaginary)) / denom;
        return this;
    }

    /** Divides a complex number by another complex number while redefining it.
     * @param pNum the complex number to divide from the existing value, if it is null, then the number is presumed to equal 0.
     * @return existing complex number that is divided by the complex number.
     * */
    public ComplexNumber divideAssign(ComplexNumber pNum) {
        return pNum != null ? divideAssign(pNum.real, pNum.imaginary) : divideAssign(0);
    }

    /** Creates a new reference using the real and imaginary components of the complex number.
     * @return The new reference object for a complex number of the same value.
     * */
    public ComplexNumber duplicate() {
        return new ComplexNumber(real, imaginary);
    }

    /** Checks whether the absolute value of the existing number is smaller than the inputted real number.
     * @param pNum real number to be checked for.
     * @return true if the absolute value of the existing complex number is smaller
     * than the inputted real number, otherwise false.
     * */
    public boolean isSmallerThan(double pNum) {
        return ComplexMath.abs(this) < pNum;
    }

    /** Checks whether the absolute value of the existing number is smaller than the absolute value of an inputted complex number.
     * @param pNum complex number to be checked for.
     * @return true if the absolute value of the existing complex number is smaller
     * than the absolute value of inputted complex number, otherwise false.
     * */
    public boolean isSmallerThan(ComplexNumber pNum) {
        return ComplexMath.abs(this) < ComplexMath.abs(pNum);
    }

    /** Checks whether the absolute value of the existing number is smaller than or equal to the inputted real number.
     * @param pNum real number to be checked for.
     * @return true if the absolute value of the existing complex number is smaller
     * than or equal to the inputted real number, otherwise false.
     * */
    public boolean isSmallerThanOrEqualTo(double pNum) {
        return ComplexMath.abs(this) <= pNum;
    }

    /** Checks whether the absolute value of the existing number is smaller than or equal to the absolute value of an inputted complex number.
     * @param pNum complex number to be checked for.
     * @return true if the absolute value of the existing complex number is smaller
     * than or equal to the absolute value of inputted complex number, otherwise false.
     * */
    public boolean isSmallerThanOrEqualTo(ComplexNumber pNum) {
        return ComplexMath.abs(this) <= ComplexMath.abs(pNum);
    }

    /** Checks whether the absolute value of the existing number is bigger than the inputted real number.
     * @param pNum real number to be checked for.
     * @return true if the absolute value of the existing complex number is bigger
     * than the inputted real number, otherwise false.
     * */
    public boolean isGreaterThan(double pNum) {
        return ComplexMath.abs(this) > pNum;
    }

    /** Checks whether the absolute value of the existing number is bigger than the absolute value of an inputted complex number.
     * @param pNum complex number to be checked for.
     * @return true if the absolute value of the existing complex number is bigger
     * than the absolute value of inputted complex number, otherwise false.
     * */
    public boolean isGreaterThan(ComplexNumber pNum) {
        return ComplexMath.abs(this) > ComplexMath.abs(pNum);
    }
    /** Checks whether the absolute value of the existing number is bigger than or equal to the inputted real number.
     * @param pNum real number to be checked for.
     * @return true if the absolute value of the existing complex number is bigger
     * than or equal to the inputted real number, otherwise false.
     * */
    public boolean isGreaterThanOrEqualTo(double pNum) {
        return ComplexMath.abs(this) >= pNum;
    }

    /** Checks whether the absolute value of the existing number is bigger than
     * or equal to the absolute value of an inputted complex number.
     * @param pNum complex number to be checked for.
     * @return true if the absolute value of the existing complex number is bigger
     * than or equal to the absolute value of inputted complex number, otherwise false.
     * */
    public boolean isGreaterThanOrEqualTo(ComplexNumber pNum) {
        return ComplexMath.abs(this) >= ComplexMath.abs(pNum);
    }

    /** Overridden from {@link Comparable},
     * returns a value based on whether the absolute value of the complex number is greater or smaller.
     * @param o The complex number being compared to.
     * @return returns 0 if this complex number and o equals to each other, -1 if this complex number is smaller than o, else returns 1.
     * */
    @Override
    public int compareTo(ComplexNumber o) {
        return ComplexMath.abs(this) == ComplexMath.abs(o) ? 0 : (isSmallerThan(o) ? -1 : 1);
    }

    /** Overridden from {@link Object},
     * checks whether the input is an instanceof number or complex number before evaluation.
     * Upon evaluation, if obj is instanceof complex number, both the real and imaginary components of the obj
     * and this complex number must match for the function to return true.
     * Otherwise, if obj is instanceof number, the imaginary value of this particular complex number has to be 0
     * and the real component must match with the number inputted.
     * @param obj Yields false if it is neither a complex number nor a basic number.
     * @return True is the value of ob j equates to this complex number.
     * */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ComplexNumber num) {
            return this.real == num.real && this.imaginary == num.imaginary;
        } else if (obj instanceof Number num) {
            return this.imaginary == 0 && this.real == num.doubleValue();
        }
        return false;
    }

    /** Overridden from {@link Object},
     * Formats the real and imaginary components into proper strings before returning the complex number in the (a+bi) format.
     * The function may also remove the imaginary or real form the toString if the magnitudes of both values are too small compared to each other.
     * @return The complex number in the (a+bi) format.
     * */
    @Override
    public String toString() {
        if (imaginary == 0 || ((imaginary + "").contains("E-") && !(real + "").contains("E-")) ||
                ((real + "").contains("E+") && !(imaginary + "").contains("E+"))) {
            return real + "";
        } else if (real == 0 || ((real + "").contains("E-") && !(imaginary + "").contains("E-")) ||
                ((imaginary + "").contains("E+") && !(real + "").contains("E+"))) {
            return imaginary + "i";
        }
        String symb = imaginary < 0 ? "" : "+";
        return real + symb + imaginary + "i";
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull ComplexNumber of(double pNum) {
        return new ComplexNumber(pNum);
    }

    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    public static ComplexNumber of(double pReal, double pImaginary) {
        return new ComplexNumber(pReal, pImaginary);
    }
}
